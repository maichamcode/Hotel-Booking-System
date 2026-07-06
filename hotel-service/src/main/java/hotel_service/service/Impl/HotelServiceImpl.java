package hotel_service.service.Impl;

import hotel_service.dto.request.CreateHotelRequestDTO;
import hotel_service.dto.request.UpdateHotelResquestDTO;
import hotel_service.dto.response.HotelResponseDTO;
import hotel_service.entity.HotelEntity;
import hotel_service.enums.Status;
import hotel_service.exception.HotelNotFoundException;
import hotel_service.exception.PhoneNumberAlreadyExistsException;
import hotel_service.mapper.HotelMapper;
import hotel_service.repo.HotelRepo;
import hotel_service.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepo hotelRepo;
    private final HotelMapper hotelMapper;

    @Override
    public List<HotelResponseDTO> findAll() {
        return hotelRepo.findAll()
                .stream()
                .map(hotelMapper::toResponseDTO)
                .toList();
    }

    @Override
    public HotelResponseDTO findById(Long id) {
        HotelEntity hotel = hotelRepo.findById(id)
                .orElseThrow(()->new HotelNotFoundException(id));
        return hotelMapper.toResponseDTO(hotel);
    }

    @Override
    public HotelResponseDTO findByPhoneNumber(String phone) {
        HotelEntity hotelPhone = hotelRepo.findByPhoneNumber(phone)
                .orElseThrow(()-> new HotelNotFoundException(phone));
        return hotelMapper.toResponseDTO(hotelPhone);
    }

    @Override
    @Transactional
    public HotelResponseDTO createHotel(CreateHotelRequestDTO createHotelRequestDTO) {
        // validate trùng phone number
        if(hotelRepo.existsByPhoneNumber(createHotelRequestDTO.getPhoneNumber())){
            throw new PhoneNumberAlreadyExistsException(createHotelRequestDTO.getPhoneNumber());
        }

        HotelEntity hotelEntity = hotelMapper.toRequestDto(createHotelRequestDTO);
        hotelEntity.setStatus(Status.ACTIVE);
        hotelRepo.save(hotelEntity);

        return hotelMapper.toResponseDTO(hotelEntity);
    }

    @Override
    @Transactional
    public HotelResponseDTO updateHotel(Long id, UpdateHotelResquestDTO updateHotelResquestDTO) {
        HotelEntity hotel = hotelRepo.findById(id)
                .orElseThrow(()-> new HotelNotFoundException(id));
        hotelMapper.updateHotel(updateHotelResquestDTO, hotel);
        return hotelMapper.toResponseDTO(hotel);
    }

    @Override
    public boolean existsByPhoneNumber(String phone) {
        return hotelRepo.existsByPhoneNumber(phone);
    }

    @Override
    public void deleteHotel(Long id) {
        HotelEntity hotel = hotelRepo.findById(id)
                .orElseThrow(()-> new HotelNotFoundException(id));
        hotelRepo.delete(hotel);
    }
}
