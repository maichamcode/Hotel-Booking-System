package hotel_service.service;

import hotel_service.dto.request.CreateHotelRequestDTO;
import hotel_service.dto.request.UpdateHotelResquestDTO;
import hotel_service.dto.response.HotelResponseDTO;
import hotel_service.entity.HotelEntity;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<HotelResponseDTO> findAll();
    HotelResponseDTO findById(Long id);
    HotelResponseDTO findByPhoneNumber(String phone);
    HotelResponseDTO createHotel(CreateHotelRequestDTO createHotelRequestDTO);
    HotelResponseDTO updateHotel(Long id, UpdateHotelResquestDTO updateHotelResquestDTO);
    boolean existsByPhoneNumber(String phone);
    void deleteHotel(Long id);
}
