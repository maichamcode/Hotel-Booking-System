package room_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import room_service.enums.BedType;
import room_service.enums.RoomType;
import room_service.enums.Status;
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
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Enumerated(EnumType.STRING)
    private BedType bedType;
    private Integer maxAdults;
    private Integer maxChildren;
    private BigDecimal area;
    private BigDecimal pricePerNight;
    private String description;
    private String thumbnail;

    @Enumerated(EnumType.STRING)
    private Status status;
}
