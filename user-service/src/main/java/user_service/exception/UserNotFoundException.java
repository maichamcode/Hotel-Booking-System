package user_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("User with id is " + userId + " Not Found");
    }
    public UserNotFoundException(String propertites) {
      super("User with email is " + propertites + " Not Found");
    }

}
