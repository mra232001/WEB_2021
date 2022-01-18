package com.example.web.controller;

import com.example.web.entity.Comment;
import com.example.web.entity.Routine;
import com.example.web.entity.User;
import com.example.web.service.MainService;
import com.example.web.service.RoutineService;
import org.hibernate.Session;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/routine")
public class RoutineController {

    @Autowired
    public MainService mainService;

    @Autowired
    public RoutineService routineService;

    @GetMapping("/")
    public String getSpecificRoutine(@RequestParam("id") int Id,
                                     @RequestParam("ses") int idSes,
                                     Model model) {
        Routine routine = mainService.findRoutinebyId(Id);
        model.addAttribute("routine", routine);
        Comment comment = new Comment();
        comment.setRoutine(routine);
        comment.setWriter(routine.getOwner());
        User user = mainService.findUserbyId(idSes);
        model.addAttribute("user",user);
        model.addAttribute("Newcomment",comment);
        return "Authenticated/SpecificRoutine";
    }

    @GetMapping("/like")
    public String Like(@RequestParam("routine") int idRoutine,
                       @RequestParam("user") int id,
                       Model model){
        Routine routine = mainService.findRoutinebyId(idRoutine);
        User foundUser = mainService.findUserbyId(id);
        foundUser.like_Routine(routine);
        routine.addLike(mainService.findUserbyId(id));
        routineService.addLike(foundUser,routine);
        mainService.saveNewNotification(foundUser,2,routine);
        model.addAttribute("routine",routine);
        return "redirect:/routine/?id=" +routine.getId()+"&ses="+id;
    }

    @GetMapping("/unlike")
    public String unlike(@RequestParam("routine") int idRoutine,
                         @RequestParam("user") int id,
                         Model model){
        Routine routine = mainService.findRoutinebyId(idRoutine);
        User foundUser = mainService.findUserbyId(id);
        foundUser.unlike_routine(routine);
        routine.unLike(foundUser);
        routineService.unLike(foundUser,routine);
        model.addAttribute("routine",routine);
        return "redirect:/routine/?id=" +routine.getId()+"&ses="+id;
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute("Newcomment") Comment comment,
                             @ModelAttribute("routine") Routine routine,
                             @RequestParam("writer") int id
                             ){
        comment.setWriter(mainService.findUserbyId(id));
        routine.addComment(comment);
        routineService.addComment(comment);
        mainService.saveNewNotification(mainService.findUserbyId(id),3,routine);
        return "redirect:/routine/?id=" +comment.getRoutine().getId()+"&ses=" +id;
    }
}
