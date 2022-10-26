package com.nestdigital.todoappbackend.controller;

import com.nestdigital.todoappbackend.dao.TodoDao;
import com.nestdigital.todoappbackend.dao.UserDao;
import com.nestdigital.todoappbackend.model.TodoModel;
import com.nestdigital.todoappbackend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserDao dao;

    @Autowired
    private TodoDao daot;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signup",consumes = "application/json",produces = "application/json")
    private String signup(@RequestBody UserModel user){
        System.out.println(user.toString());
        dao.save(user);
        return "(status:'success')";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signin",consumes = "application/json",produces = "application/json")
    public List<UserModel>signin(@RequestBody UserModel signin){
    return (List<UserModel>) dao.signin(signin.getEmail(),signin.getPassword());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addtodo",consumes = "application/json",produces = "application/json")
    private String addtodo(@RequestBody TodoModel todo){
        System.out.println(todo.toString());
        daot.save(todo);
        return "(status:'success')";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/mytodos",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>>mytodos(@RequestBody TodoModel todo){
        return (List<Map<String,String>>)daot.myTodos(todo.getUserid());
    }

}
