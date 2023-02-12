package de.valentin.PESG.controller;

import de.valentin.PESG.entity.User;
import de.valentin.PESG.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/changePassword")
    public User changePassword(@RequestBody User user) {
        return userService.changePassword(user.getId(), user.getPassword());
    }


}
