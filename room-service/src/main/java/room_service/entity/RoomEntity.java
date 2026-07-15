package room_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import room_service.BedType;
import room_service.RoomType;
import room_service.Status;
import room_service.util.AbstractAuditor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class RoomEntity extends AbstractAuditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private String roomName;
    private RoomType roomType;
    private BedType bedType;
    private Integer maxAdults;
    private Integer maxChildren;
    private BigDecimal area;
    private BigDecimal pricePerNight;
    private String description;
    private String thumbnail;
    private Status status;
}
