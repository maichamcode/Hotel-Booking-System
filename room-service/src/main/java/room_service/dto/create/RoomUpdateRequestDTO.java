package room_service.dto.create;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import room_service.enums.BedType;
import room_service.enums.RoomType;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RoomUpdateRequestDTO {
    private String roomNumber;
    private String roomName;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Enumerated(EnumType.STRING)
    private BedType bedType;
    private Integer maxAdults;
    private Integer maxChildren;
    private BigDecimal pricePerNight;
    private String description;
    private BigDecimal area;
}
