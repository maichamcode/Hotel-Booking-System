package room_service.mapper;

import org.mapstruct.Mapper;
import room_service.dto.create.RoomCreateRequestDTO;
import room_service.dto.response.RoomResponseDTO;
import room_service.entity.RoomEntity;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomResponseDTO toResponseDto(RoomEntity roomEntity);
    RoomEntity toRequestDto(RoomCreateRequestDTO roomCreateRequestDTO);
}
