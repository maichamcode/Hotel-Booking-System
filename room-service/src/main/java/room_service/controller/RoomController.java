package room_service.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import room_service.dto.create.RoomCreateRequestDTO;
import room_service.dto.response.RoomResponseDTO;
import room_service.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomResponseDTO>> findAll(){
        List<RoomResponseDTO> rooms = roomService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDTO> findById(@PathVariable Long id){
        RoomResponseDTO room = roomService.getRoomById(id);
        return ResponseEntity.status(HttpStatus.OK).body(room);
    }

    @PostMapping
    public ResponseEntity<RoomResponseDTO> create(@RequestBody RoomCreateRequestDTO roomCreateRequestDTO){
        RoomResponseDTO room = roomService.createRoom(roomCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }
}
