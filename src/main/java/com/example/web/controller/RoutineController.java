package com.example.web.controller;

import com.example.web.entity.Routine;
import com.example.web.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/routine")
public class RoutineController {

    @Autowired
    public MainService mainService;

    public String getSpecificRoutine(@RequestParam("id") int Id,
                                     Model model) {
        Routine routine = mainService.findRoutineById(Id);
        model.addAttribute("routine", routine);
        return "Authenticated/MySpecificRoutine";
    }
}
