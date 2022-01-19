package com.example.web.service;

import com.example.web.entity.*;
import com.example.web.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainService  {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public RoutineRepository routineRepository;

    @Autowired
    public ExerciseRepository exerciseRepository;

    @Autowired
    public NotificationRepository notificationRepository;

    @Autowired
    public NodeRepository nodeRepository;

    public MainService(){

    }

    public MainService(UserRepository userRepository, RoutineRepository routineRepository){
        this.routineRepository = routineRepository;
        this.userRepository = userRepository;
    }

    public List<User> findUserById(int id){
        return userRepository.findUsersById(id);
    }


    public List<Routine> findRoutineByName(String name){
        return routineRepository.findRoutineByName(name);
    }


    public List<Exercise> listAllExercises(){
        return exerciseRepository.findAll();
    }


    public Exercise findExerciseById(int id){
        return exerciseRepository.getById(id);
    }

    public List<User> findUserbyUsername(String username){
        return userRepository.findUsersByUsername(username);
    }

    public User findOneUerbyUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<Routine> findRoutineById(int id){
        return routineRepository.findRoutineById(id);
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public User findUserbyId(int Id){
        Optional<User> result = userRepository.findById(Id);
        User user = null;
        if(result!= null){
            user = result.get();
        } else {
            throw new RuntimeException("Did not find user with the id " + Id);
        }

        return user;

    }

    public Routine findRoutinebyId(int Id){
        Optional<Routine> result = routineRepository.findById(Id);
        Routine routine = null;
        if(result != null){
            routine = result.get();
        } else {
            throw new RuntimeException("Did not find routine with the id " +Id);
        }
        return routine;
    }

    public void addNewFollow(User follower, User followed){
        userRepository.save(followed);
        userRepository.save(follower);
    }

    public void saveNewNotification(User writer,int type, Object targer){
        Notification notification = new Notification();
        notification.setWriter(writer);
        notification.setType(type);
        if(type == 1){
            String description = writer.getUsername()+ " has followed you";
            notification.setDescription(description);
            notification.setReceiver((User) targer);
        } else {
            if(type == 2){
                String description = writer.getUsername()+ " has liked your post";
                notification.setDescription(description);
                notification.setRoutine((Routine) targer);
                notification.setReceiver( ((Routine) targer).getOwner());
            } else {
                String description = writer.getUsername()+ " has commented on your post";
                notification.setDescription(description);
                notification.setRoutine((Routine) targer);
                notification.setReceiver( ((Routine) targer).getOwner());
            }
        }
        notification.getReceiver().addNewNoti(notification);
        notificationRepository.save(notification);
    }
}
