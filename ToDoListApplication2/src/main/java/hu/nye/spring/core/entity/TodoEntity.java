package hu.nye.spring.core.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity

public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;
    private boolean completed=Boolean.FALSE;

    public Boolean getCompleted() {
        return completed;
    }

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    private Date date;
}
