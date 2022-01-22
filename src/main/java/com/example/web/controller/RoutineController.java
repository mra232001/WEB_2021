package com.example.web.controller;

import com.example.web.entity.*;
import com.example.web.service.MainService;
import com.example.web.service.RoutineService;
import org.hibernate.Session;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/likeother")
    public String Likeother(@RequestParam("routine") int idRoutine,
                       @RequestParam("user") int id,
                       Model model){
        Routine routine = mainService.findRoutinebyId(idRoutine);
        User foundUser = mainService.findUserbyId(id);
        foundUser.like_Routine(routine);
        routine.addLike(mainService.findUserbyId(id));
        routineService.addLike(foundUser,routine);
        mainService.saveNewNotification(foundUser,2,routine);
        model.addAttribute("routine",routine);
        return "redirect:/profile/?userId=" + routine.getOwner().getId()+"&ses="+foundUser.getId();
    }

    @GetMapping("/unlikeother")
    public String unlikeother(@RequestParam("routine") int idRoutine,
                         @RequestParam("user") int id,
                         Model model){
        Routine routine = mainService.findRoutinebyId(idRoutine);
        User foundUser = mainService.findUserbyId(id);
        foundUser.unlike_routine(routine);
        routine.unLike(foundUser);
        routineService.unLike(foundUser,routine);
        model.addAttribute("routine",routine);
        return "redirect:/profile/?userId=" + routine.getOwner().getId()+"&ses="+foundUser.getId();
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

    @GetMapping("/likehomepage")
    public String Likehomepage(@RequestParam("routine") int idRoutine,
                       @RequestParam("user") int id,
                       Model model){
        Routine routine = mainService.findRoutinebyId(idRoutine);
        User foundUser = mainService.findUserbyId(id);
        foundUser.like_Routine(routine);
        routine.addLike(mainService.findUserbyId(id));
        routineService.addLike(foundUser,routine);
        mainService.saveNewNotification(foundUser,2,routine);
        model.addAttribute("routine",routine);
        return "redirect:/main/?user=" +id;
    }

    @GetMapping("/unlikehomepage")
    public String unlikehomepage(@RequestParam("routine") int idRoutine,
                         @RequestParam("user") int id,
                         Model model){
        Routine routine = mainService.findRoutinebyId(idRoutine);
        User foundUser = mainService.findUserbyId(id);
        foundUser.unlike_routine(routine);
        routine.unLike(foundUser);
        routineService.unLike(foundUser,routine);
        model.addAttribute("routine",routine);
        return "redirect:/main/?user=" +id;
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
    List <Routine> routineList = new ArrayList<>();
    @GetMapping("/createname")
    public String create_name_for_routine(@RequestParam("id") int id, Model model){
        Routine routine = new Routine();
        User user = mainService.findUserbyId(id);
        /// connect time
        user.getRoutineList().add(routine);
        routine.setOwner(user);
        System.out.println(user.getId());
        model.addAttribute("routine", routine);
        return "Authenticated/RoutineName";
    }
    @PostMapping("/create")
    public String Continue(@ModelAttribute("routine") Routine routine, @RequestParam("id") int id, Model model){
        /// cung routine cu
        User user = routine.getOwner();
        mainService.routineRepository.save(routine);
        Node node = new Node();
        model.addAttribute("routine", routine);
        model.addAttribute("node", node);
        model.addAttribute("exerciseList", mainService.listAllExercises());
        return "Authenticated/CreatenewRoutine";
    }
    @PostMapping("/thembaitap")
    public String thembaitap(@RequestParam("id") int id, @ModelAttribute("node") Node node, Model model){
        /// node chua connect
        /// field name van con giu
        /// cung 1 routine
        Routine routine = mainService.findRoutinebyId(id);
        Exercise exercise = mainService.exerciseRepository.findById(node.getIdex());
        node.setExercise(exercise);
        node.setRoutine(routine);
        mainService.nodeRepository.save(node);
        Node n = new Node();
        model.addAttribute("node", n);
        model.addAttribute("routine", routine);
        model.addAttribute("exerciseList", mainService.listAllExercises());
        return "Authenticated/CreatenewRoutine";
    }

    @GetMapping("/configure")
    public String configure(@RequestParam("id") int id, Model model){
        Routine routine = mainService.findRoutinebyId(id);
        mainService.routineRepository.save(routine);
        Node node = new Node();
        model.addAttribute("routine", routine);
        model.addAttribute("node", node);
        model.addAttribute("exerciseList", mainService.listAllExercises());
        return "Authenticated/CreatenewRoutine";
    }

    @GetMapping("/save")
    public String luu(@RequestParam("id") int id){
        User user = mainService.findUserbyId(id);
        mainService.saveUser(user);
        return "redirect:/main/?user=" +id;
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") int id){
        Routine routine = mainService.findRoutinebyId(id);
        mainService.deleteRoutine(routine);
        return "redirect:/profile/?userId=" + routine.getOwner().getId()+"&ses="+routine.getOwner().getId();
    }

    @GetMapping("deleteExercise")
    public String deleteExercise(@RequestParam("id") int id,
                                 @RequestParam("node") int idNode){
        Routine routine = mainService.findRoutinebyId(id);
        routineService.deleteNode(idNode);
        return "redirect:/routine/?id=" +routine.getId()+"&ses=" +routine.getOwner().getId();
    }

    @GetMapping("copy")
    public String copy(@RequestParam("routine") int id,
                       @RequestParam("ses") int idSes,
                       Model model){
        Routine routine = mainService.findRoutinebyId(id);
        User user = mainService.findUserbyId(idSes);
        Routine routine1 = new Routine(routine);
        routine1.setOwner(user);
        for(Node node:routine.getNode()){
            Node node1 = new Node();
            node1.setRoutine(routine1);
            node1.setExercise(node.getExercise());
        }
        mainService.routineRepository.save(routine1);
        Node node = new Node();
        model.addAttribute("routine", routine1);
        model.addAttribute("node", node);
        model.addAttribute("exerciseList", mainService.listAllExercises());
        return "Authenticated/CreatenewRoutine";
    }
}
