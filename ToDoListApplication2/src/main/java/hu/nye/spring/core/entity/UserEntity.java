package hu.nye.spring.core.entity;

import jakarta.persistence.Entity;
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
@Entity
public class UserEntity {
    @Id
    private Long id;

    private String username;
    private String password;

    @OneToMany
private List<Todo> todoList=new ArrayList<>();


}
