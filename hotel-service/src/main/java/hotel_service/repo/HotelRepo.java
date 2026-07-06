package hotel_service.repo;

import hotel_service.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<HotelEntity, Long> {
    Optional<HotelEntity> findByPhoneNumber(String phone);
    boolean existsByPhoneNumber(String phone);
}
