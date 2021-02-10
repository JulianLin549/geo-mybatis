package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public List<User> userList() {
        return userService.selectAllUser();
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping("/getDistance")
    public List<User> getDistance(@RequestParam(name = "lng") String lng,
                              @RequestParam(name = "lat") String lat,
                              @RequestParam(name = "dis") String dis) {
        return userService.selectByDistance(lng, lat, dis);
    }

}
