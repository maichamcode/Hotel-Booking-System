package room_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import room_service.dto.create.RoomCreateRequestDTO;
import room_service.dto.create.RoomUpdateRequestDTO;
import room_service.dto.response.RoomResponseDTO;
import room_service.entity.RoomEntity;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface RoomMapper {
    RoomResponseDTO toResponseDto(RoomEntity roomEntity);
    RoomEntity toRequestDto(RoomCreateRequestDTO roomCreateRequestDTO);
    void updateRoom(RoomUpdateRequestDTO roomUpdateRequestDTO, @MappingTarget RoomEntity roomEntity);
}
