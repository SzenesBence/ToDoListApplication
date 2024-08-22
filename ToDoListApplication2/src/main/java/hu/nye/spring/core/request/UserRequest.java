package hu.nye.spring.core.request;
import hu.nye.spring.core.security.BCrytpHashing;
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
