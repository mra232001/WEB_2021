package com.example.web.controller;

import com.example.web.entity.Exercise;
import com.example.web.more.Input;
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
        if(type.equals("Person")) return "Manh/ResultOfFilter"; else
            return "Manh/ResultofFilter2";
    }

    @GetMapping("/list_exercises")
    public String list_exercises(Model model){

        List<Exercise> exerciseList = mainService.listAllExercises();
        model.addAttribute("exerciseList",exerciseList);

        return "Authenticated/ListExercises";
    }

}
