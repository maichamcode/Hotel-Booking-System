package room_service.service;

import room_service.dto.create.RoomCreateRequestDTO;
import room_service.dto.response.RoomResponseDTO;

import java.util.List;

public interface RoomService {
    List<RoomResponseDTO> findAll();
    RoomResponseDTO createRoom(RoomCreateRequestDTO request);

    RoomResponseDTO getRoomById(Long id);

//    RoomResponseDTO updateRoom(Long id, UpdateRoomRequest request);

//    void deleteRoom(Long id);
}
