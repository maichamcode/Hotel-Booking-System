package room_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import room_service.entity.RoomEntity;
import room_service.enums.Status;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<RoomEntity, Long> {
    Optional<RoomEntity> findByRoomNumber(String roomNumber);

    boolean existsByRoomNumber(String roomNumber);

    List<RoomEntity> findByStatus(Status status);
}
