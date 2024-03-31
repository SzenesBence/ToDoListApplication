package hu.nye.spring.core;

import hu.nye.spring.core.entity.Todo;
import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.repository.TodoRepository;
import hu.nye.spring.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TodoRepository todoRepository;

    public static void main(String[] args) {
        try {
            SpringApplication.run(Main.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity userEntity=new UserEntity();
        userEntity.setId(1L);
        userEntity.setPassword("password");
        userEntity.setUsername("John");

        Todo todo = new Todo();
        todo.setId(1L);
        todo.setContent("Finish mapping");
        userEntity.getTodoList().add(todo);

        todoRepository.save(todo);
        userRepository.save(userEntity);


    }
}
