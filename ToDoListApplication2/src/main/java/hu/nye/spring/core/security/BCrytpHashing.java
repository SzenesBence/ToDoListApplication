package hu.nye.spring.core.security;
import hu.nye.spring.core.request.UserRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class BCrytpHashing {
    public static String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
