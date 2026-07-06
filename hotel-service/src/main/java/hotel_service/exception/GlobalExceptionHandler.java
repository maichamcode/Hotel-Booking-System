package hotel_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HotelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleHotelNotFoundException(HotelNotFoundException hotelNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hotelNotFoundException.getMessage());
    }

    @ExceptionHandler(PhoneNumberAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handlePhoneNumberAlreadyExistsException(PhoneNumberAlreadyExistsException phoneNumberAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(phoneNumberAlreadyExistsException.getMessage());
    }
}
