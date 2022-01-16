package com.example.web.controller;

import com.example.web.entity.Exercise;
import com.example.web.entity.Routine;
import com.example.web.entity.User;
import com.example.web.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String main_page(Model model){
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
                User user = mainService.findUserById(inputId);
                List<User> users = new ArrayList<>();
                users.add(user);
                theModel.addAttribute("users",user);
                return "Authenticated/ResultOfFilter";
            } else{
                List<Routine> routineList = new ArrayList<>();
                Routine routine = mainService.findRoutineById(inputId);
                routineList.add(routine);
                theModel.addAttribute("routines",routineList);
                return "Authenticated/ResultofFilter2";
            }

        }
        if(type.equals("Person")){
            return "Authenticated/ResultOfFilter";
        } else
            return "Authenticated/ResultofFilter2";
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
            result = result * 10 + Integer.valueOf(c);
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

}
