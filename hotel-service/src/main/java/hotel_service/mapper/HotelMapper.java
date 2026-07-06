package hotel_service.mapper;

import hotel_service.dto.request.CreateHotelRequestDTO;
import hotel_service.dto.request.UpdateHotelResquestDTO;
import hotel_service.dto.response.HotelResponseDTO;
import hotel_service.entity.HotelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    HotelResponseDTO toResponseDTO(HotelEntity hotelEntity);
    HotelEntity toRequestDto(CreateHotelRequestDTO createHotelRequestDTO);
    void updateHotel(UpdateHotelResquestDTO updateHotelResquestDTO, @MappingTarget HotelEntity hotelEntity);
}
