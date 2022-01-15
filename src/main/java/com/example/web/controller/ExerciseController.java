package com.example.web.controller;

import com.example.web.entity.Exercise;
import com.example.web.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    public MainService mainService;

    @GetMapping("/detail")
    public String showDetailExercise(@RequestParam("id") int Id,
                                     Model model){
        Exercise exercise = mainService.findById(Id);
        model.addAttribute("exercise",exercise);
        return "Authenticated/SpecificExercise";
    }
}
