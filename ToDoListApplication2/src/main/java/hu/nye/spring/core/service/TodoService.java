package hu.nye.spring.core.service;
import hu.nye.spring.core.entity.TodoEntity;
import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.exception.UserNotFoundException;
import hu.nye.spring.core.repository.TodoRepository;
import hu.nye.spring.core.repository.UserRepository;
import hu.nye.spring.core.request.TodoRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService implements ITodoService {
@Autowired
    TodoRepository todoRepository;
@Autowired
UserRepository userRepository;

    @SneakyThrows
    @Override
    public TodoEntity getTodoByID(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(UserNotFoundException::new);
    }

    @SneakyThrows
    @Override
    public void addTodo(Long userId, TodoRequest todoRequest) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setContent(todoRequest.getContent());
        todoEntity.setDate(todoRequest.getDate());
        userEntity.getTodoList().add(todoEntity);
        todoRepository.save(todoEntity);
    }
    @SneakyThrows
    @Override
    public void toogleTodoCompleted(Long todoId) {
        TodoEntity todoEntity = todoRepository.findById(todoId).orElseThrow(UserNotFoundException::new);
        todoEntity.setCompleted(!todoEntity.getCompleted());
        todoRepository.save(todoEntity);
    }
    @SneakyThrows
    @Override
    public void deleteTodo(Long userId, Long todoId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        TodoEntity todoEntity = todoRepository.findById(todoId).orElseThrow(UserNotFoundException::new);
        userEntity.getTodoList().remove(todoEntity);
        todoRepository.delete(todoEntity);
    }
}
