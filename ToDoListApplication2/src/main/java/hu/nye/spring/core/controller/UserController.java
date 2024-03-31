package hu.nye.spring.core.controller;

import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.repository.TodoRepository;
import hu.nye.spring.core.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  private UserRepository userRepository;
private TodoRepository todoRepository;

    public UserController(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }
    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Long userId){
        return userRepository.findById(userId).orElseThrow();
    }
}
