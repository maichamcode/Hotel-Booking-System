package hotel_service.dto.response;

import hotel_service.enums.Status;
import lombok.Data;

@Data
public class HotelResponseDTO {
    private Long id;

    private String name;

    private String description;

    private String phoneNumber;

    private String email;

    private Status status;
}
