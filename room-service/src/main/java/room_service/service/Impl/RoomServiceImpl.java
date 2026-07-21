package room_service.service.Impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import room_service.dto.create.RoomCreateRequestDTO;
import room_service.dto.response.RoomResponseDTO;
import room_service.entity.RoomEntity;
import room_service.enums.Status;
import room_service.exception.RoomNotFoundException;
import room_service.exception.RoomNumberAlreadyExistsException;
import room_service.mapper.RoomMapper;
import room_service.repo.RoomRepo;
import room_service.service.RoomService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepo roomRepo;
    private final RoomMapper roomMapper;

    @Override
    public List<RoomResponseDTO> findAll() {
        return roomRepo.findAll()
                .stream()
                .map(roomMapper::toResponseDto)
                .toList();
    }

    @Override
    public RoomResponseDTO createRoom(RoomCreateRequestDTO request) {
        // check exists room number
        if(roomRepo.existsByRoomNumber(request.getRoomNumber())){
            throw new RoomNumberAlreadyExistsException(request.getRoomNumber());
        }
        RoomEntity roomEntity = roomMapper.toRequestDto(request);
        roomEntity.setStatus(Status.AVAILABLE);
        roomRepo.save(roomEntity);

        return roomMapper.toResponseDto(roomEntity);
    }

    @Override
    public RoomResponseDTO getRoomById(Long id) {
        RoomEntity roomEntity = roomRepo.findById(id)
                .orElseThrow(()-> new RoomNotFoundException(id));
        return roomMapper.toResponseDto(roomEntity);
    }
}
