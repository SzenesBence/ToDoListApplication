package hu.nye.spring.core.request;

import hu.nye.spring.core.entity.Todo;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {
    @Id
    private Long id;

    private String username;
    private String password;

    @OneToMany
    private List<Todo> todoList=new ArrayList<>();

}
