package room_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RoomNumberAlreadyExistsException extends RuntimeException {
    public RoomNumberAlreadyExistsException(String roomNumber) {
        super("Room Number already exist with "+roomNumber);
    }
}
