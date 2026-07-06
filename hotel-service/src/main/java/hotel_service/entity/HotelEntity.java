package hotel_service.entity;

import hotel_service.enums.Status;
import hotel_service.util.AbstractAuditor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class HotelEntity extends AbstractAuditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String phoneNumber;

    private String email;

    private String address;

    private String city;

    private String country;

    private String postalCode;

    private Double latitude;

    private Double longitude;

    @Enumerated(EnumType.STRING)
    private Status status;
}
