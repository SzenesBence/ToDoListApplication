package hu.nye.spring.core.request;

import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TodoRequest {
    @Id
    private Long id;
    private String content;
    private boolean completed=Boolean.FALSE;
}
