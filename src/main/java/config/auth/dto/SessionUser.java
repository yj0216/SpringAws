package config.auth.dto;

import com.example.springaws.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String pictures;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.pictures = user.getPicture();
    }
}
