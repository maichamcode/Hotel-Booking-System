package room_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RoomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleRoomNotFoundException(RoomNotFoundException roomNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(roomNotFoundException.getMessage());
    }

    @ExceptionHandler(RoomNumberAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleRoomNumberAlreadyExistsException(RoomNumberAlreadyExistsException roomNumberAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(roomNumberAlreadyExistsException.getMessage());
    }
}
