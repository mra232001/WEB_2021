package com.example.web.controller;

import com.example.web.entity.Exercise;
import com.example.web.entity.Routine;
import com.example.web.entity.User;
import com.example.web.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private MainService mainService;

    public MainController(MainService mainService){
        this.mainService = mainService;
    }

    @RequestMapping("")
    public String main_page(@RequestParam("user")int id,
                                        Model model){
        User user = mainService.findUserbyId(id);
        List<Routine> routineList = new ArrayList<>();
        routineList = user.routineList;
        for(User user1: user.getFollowing()){
            for(Routine routine1: user1.getRoutineList()){
                routineList.add(routine1);
            }
        };
        model.addAttribute("list_routine",routineList);
        model.addAttribute("user",user);
        return "Authenticated/Home_page";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        List<Integer> listRoutines = new ArrayList<>();
        model.addAttribute("list_routines",listRoutines);
        return "Authenticated/MyPersonalPage";
    }

    @GetMapping("/search")
    public String search(@RequestParam("input") String input,
                         @RequestParam("Type") String type,
                         Model theModel){
        if(IsId(input)){
            int inputId = ConvertStringToInt(input);
            if(type.equals("Person")){
                List<User> users = mainService.findUserById(inputId);
                theModel.addAttribute("users",users);
                return "Authenticated/ResultOfFilter";
            } else{
                List<Routine> routineList = new ArrayList<>();
                routineList = mainService.findRoutineById(inputId);
                theModel.addAttribute("routines",routineList);
                return "Authenticated/ResultofFilter2";
            }

        } else {
            if(type.equals("Person")){
                List<User> userList = mainService.findUserbyUsername(input);
                theModel.addAttribute("users",userList);
                return "Authenticated/ResultOfFilter";
            } else {
                List<Routine> routineList = new ArrayList<>();
                routineList = mainService.findRoutineByName(input);
                theModel.addAttribute("routines",routineList);
                return "Authenticated/ResultofFilter2";
            }
        }

    }

    @GetMapping("/list_exercises")
    public String list_exercises(Model model){

        List<Exercise> exerciseList = mainService.listAllExercises();
        model.addAttribute("exerciseList",exerciseList);

        return "Authenticated/ListExercises";
    }

    private int ConvertStringToInt(String input){
        int result = 0;
        char[] chars = input.toCharArray();
        for(char c: chars){
            result = result * 10 + Integer.valueOf(c-'0');
        }
        return result;
    }

    private boolean IsId(String input){
        boolean result = true;
        char[] chars = input.toCharArray();
        for(char c: chars){
            if(!Character.isDigit(c)) result = false;
        }
        return result;
    }

    @GetMapping("/follow")
    public String followUser(@RequestParam("from") int idfrom,
                             @RequestParam("to") int idTo
    ){
        User Follower = mainService.findUserbyId(idfrom);
        User Followed = mainService.findUserbyId(idTo);
        Follower.follow(Followed);
        Followed.befollowed(Follower);
        mainService.addNewFollow(Follower,Followed);
        mainService.saveNewNotification(Follower,1,Followed);
        return "redirect:/profile/?userId=" + idTo +"&ses="+ idfrom;
    }

    @GetMapping("/unfollow")
    public String unfollowUser(@RequestParam("from") int idfrom,
                               @RequestParam("to") int idTo){
        User Follower = mainService.findUserbyId(idfrom);
        User Followed = mainService.findUserbyId(idTo);
        Follower.unfollow(Followed);
        Followed.beUnfollow(Follower);
        mainService.addNewFollow(Follower,Followed);
        return "redirect:/profile/?userId=" + idTo +"&ses="+ idfrom;
    }

    @GetMapping("/notification")
    public String showNoti(@RequestParam("ses") int idSes,
                           Model model){
        User sesUser = mainService.findUserbyId(idSes);
        model.addAttribute("sesUser",sesUser);
        return "Authenticated/Notification";
    }
}
