package hu.nye.spring.core.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class TodoEntity {
    @Id
    private Long id;
    private String content;
    private boolean completed=Boolean.FALSE;

}
