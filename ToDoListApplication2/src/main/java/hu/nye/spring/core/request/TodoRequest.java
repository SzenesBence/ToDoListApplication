package hu.nye.spring.core.request;

import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TodoRequest {
    private String content;
    private boolean completed=Boolean.FALSE;
    private Date date;


}
