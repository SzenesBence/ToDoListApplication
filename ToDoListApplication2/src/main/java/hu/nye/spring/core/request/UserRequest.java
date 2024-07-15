package hu.nye.spring.core.request;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {
    private String username;
    private String password;


}
