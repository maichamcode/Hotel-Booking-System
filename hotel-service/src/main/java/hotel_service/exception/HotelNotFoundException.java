package hotel_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HotelNotFoundException extends RuntimeException {
  public HotelNotFoundException(Long hotelId) {
    super("Hotel with id is " + hotelId + " Not Found");
  }
  public HotelNotFoundException(String phone) {
    super("Hotel with phone nunber is " + phone + " Not Found");
  }
}
