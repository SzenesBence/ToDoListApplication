package hu.nye.spring.core;

import hu.nye.spring.core.entity.TodoEntity;
import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.exception.UserNotFoundException;
import hu.nye.spring.core.repository.TodoRepository;
import hu.nye.spring.core.repository.UserRepository;
import hu.nye.spring.core.request.TodoRequest;
import hu.nye.spring.core.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TodoService todoService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addTodo_ValidUserId_ShouldAddTodoToUser() {
        // GIVEN
        Long userId = 1L;
        TodoRequest todoRequest = new TodoRequest(); // Using Date object
        UserEntity userEntity = new UserEntity();
        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));

        // WHEN
        todoService.addTodo(userId, todoRequest);

        // THEN
        verify(userRepository).findById(userId);
        assertEquals(1, userEntity.getTodoList().size());
        TodoEntity todoEntity = userEntity.getTodoList().get(0);
        assertEquals(todoRequest.getContent(), todoEntity.getContent());
        assertEquals(todoRequest.getDate(), todoEntity.getDate());
        assertFalse(todoEntity.getCompleted());
        verify(todoRepository).save(todoEntity);
    }
    @Test
    public void toogleTodoCompleted_ValidTodoId_ShouldToggleCompleted() {
        // GIVEN
        Long todoId = 1L;
        TodoEntity todoEntity = new TodoEntity();
        when(todoRepository.findById(todoId)).thenReturn(Optional.of(todoEntity));

        // WHEN
        todoService.toogleTodoCompleted(todoId);

        // THEN
        verify(todoRepository).findById(todoId);
        assertTrue(todoEntity.getCompleted());
        verify(todoRepository).save(todoEntity);
    }
    @Test
    public void deleteTodo_ValidUserIdAndTodoId_ShouldDeleteTodo() {
        // GIVEN
        Long userId = 1L;
        Long todoId = 1L;
        TodoEntity todoEntity = new TodoEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.getTodoList().add(todoEntity);
        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));
        when(todoRepository.findById(todoId)).thenReturn(Optional.of(todoEntity));

        // WHEN
        todoService.deleteTodo(userId, todoId);

        // THEN
        verify(userRepository).findById(userId);
        verify(todoRepository).findById(todoId);
        assertEquals(0, userEntity.getTodoList().size());
        verify(todoRepository).delete(todoEntity);
    }
    @Test
    public void getTodoByID_TodoFound_ShouldReturnTodoEntity() {
        // GIVEN
        Long todoId = 1L;
        TodoEntity todoEntity = new TodoEntity();
        when(todoRepository.findById(todoId)).thenReturn(Optional.of(todoEntity));

        // WHEN
        TodoEntity result = todoService.getTodoByID(todoId);

        // THEN
        verify(todoRepository).findById(todoId);
        assertEquals(todoEntity, result);
    }

    @Test(expected = UserNotFoundException.class)
    public void getTodoByID_TodoNotFound_ShouldThrowUserNotFoundException() {
        // GIVEN
        Long todoId = 1L;
        when(todoRepository.findById(todoId)).thenReturn(Optional.empty());

        // WHEN
        todoService.getTodoByID(todoId);

        // THEN
        // UserNotFoundException is expected to be thrown
    }

}
