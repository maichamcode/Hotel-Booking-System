package room_service.dto.response;

import lombok.Data;
import room_service.enums.BedType;
import room_service.enums.RoomType;
import room_service.enums.Status;

import java.math.BigDecimal;
@Data
public class RoomResponseDTO {
    private Long id;
    private String roomNumber;
    private String roomName;
    private RoomType roomType;
    private BedType bedType;
    private BigDecimal pricePerNight;
    private Status status;
}
