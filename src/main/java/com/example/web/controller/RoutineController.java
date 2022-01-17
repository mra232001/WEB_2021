package com.example.web.controller;

import com.example.web.entity.Comment;
import com.example.web.entity.Routine;
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
                                     Model model) {
        Routine routine = mainService.findRoutinebyId(Id);
        model.addAttribute("routine", routine);
        Comment comment = new Comment();
        comment.setRoutine(routine);
        comment.setWriter(routine.getOwner());
        model.addAttribute("Newcomment",comment);
        return "Authenticated/SpecificRoutine";
    }

    @GetMapping("/like")
    public String Like(@ModelAttribute("routine") Routine routine,
                       Model model){
        routine.setLikeNumber(routine.getLikeNumber() + 1);
        model.addAttribute("routine",routine);
        return "redirect:/routine/?id=" +routine.getId();
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute("Newcomment") Comment comment,
                             @ModelAttribute("routine") Routine routine,
                             @RequestParam("writer") int id
                             ){
        comment.setWriter(mainService.findUserbyId(id));
        routine.addComment(comment);
        routineService.addComment(comment);
        return "redirect:/routine/?id=" +comment.getRoutine().getId();
    }
}
