package hotel_service.controller;


import hotel_service.dto.request.CreateHotelRequestDTO;
import hotel_service.dto.request.UpdateHotelResquestDTO;
import hotel_service.dto.response.HotelResponseDTO;
import hotel_service.entity.HotelEntity;
import hotel_service.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelResponseDTO>> findAll(){
        List<HotelResponseDTO> hotels = hotelService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponseDTO> findById(@PathVariable Long id){
        HotelResponseDTO hotel = hotelService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }

    @PostMapping
    public ResponseEntity<HotelResponseDTO> createHotel(@RequestBody CreateHotelRequestDTO createHotelRequestDTO){
        HotelResponseDTO hotel = hotelService.createHotel(createHotelRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponseDTO> updateHotel(@PathVariable Long id, @RequestBody UpdateHotelResquestDTO updateHotelResquestDTO){
        HotelResponseDTO hotelResponseDTO = hotelService.updateHotel(id, updateHotelResquestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(hotelResponseDTO);
    }


}
