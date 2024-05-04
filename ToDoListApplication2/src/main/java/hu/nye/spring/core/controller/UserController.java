package hu.nye.spring.core.controller;

import hu.nye.spring.core.entity.TodoEntity;
import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.request.TodoRequest;
import hu.nye.spring.core.request.UserRequest;
import hu.nye.spring.core.service.TodoService;
import hu.nye.spring.core.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TodoService todoService;

    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Long userId){
            return userService.getUserById(userId);
    }

   @PostMapping
    public UserEntity addUser(@RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
 userService.deleteUser(userId);
    }

    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Long userId, @RequestBody TodoRequest todoRequest){
   todoService.addTodo(userId,todoRequest);
    }
    @PostMapping("/todos/{todoId}")
    public void toggleTodoCompleted( @PathVariable Long todoId) {
        todoService.toogleTodoCompleted(todoId);
    }

    @DeleteMapping("{userId}/todos/{todoId}")
    public void deleteTodo(@PathVariable Long userId,@PathVariable Long todoId){
        todoService.deleteTodo(userId,todoId);
    }
    @GetMapping("{userId}/todos/{todoId}")
        public TodoEntity getTodoByID(@PathVariable Long todoId){ return todoService.getTodoByID(todoId);}
}
