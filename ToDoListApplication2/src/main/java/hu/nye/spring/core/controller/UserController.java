package hu.nye.spring.core.controller;

import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Long userId){
            return userService.getUserById(userId);
    }

   @PostMapping
    public UserEntity addUser(@RequestBody UserEntity userEntity){
        return userService.addUser(userEntity);
    }
}
