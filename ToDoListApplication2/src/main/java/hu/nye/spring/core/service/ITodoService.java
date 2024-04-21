package hu.nye.spring.core.service;

import hu.nye.spring.core.entity.TodoEntity;
import hu.nye.spring.core.request.TodoRequest;

public interface ITodoService {
void addTodo(Long userId,TodoRequest todoRequest);
void toogleTodoCompleted(Long todoID);
void deleteTodo(Long userId,Long todoId);
}
