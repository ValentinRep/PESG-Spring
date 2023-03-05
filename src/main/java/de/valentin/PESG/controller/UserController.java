package de.valentin.PESG.controller;

import de.valentin.PESG.config.JwtService;
import de.valentin.PESG.entity.User;
import de.valentin.PESG.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if(userService.authenticate(email, password)){
            return new ResponseEntity<User>(userService.findByMail(email).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/exists")
    public boolean exists(@RequestBody Map<String, String> request){
        String email = request.get("email");
        return (userService.exists(email));
    }


}
