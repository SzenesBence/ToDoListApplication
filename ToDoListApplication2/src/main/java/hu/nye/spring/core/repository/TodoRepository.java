package hu.nye.spring.core.repository;

import hu.nye.spring.core.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
