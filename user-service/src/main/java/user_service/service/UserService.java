package user_service.service;

import user_service.dto.request.CreateUserRequestDTO;
import user_service.dto.request.UpdateUserRequestDTO;
import user_service.dto.response.UserResponseDTO;
import user_service.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDTO> findAll();
    UserResponseDTO findById(Long userId);
    UserResponseDTO findByEmail(String email);
    UserResponseDTO findByPhoneNumber(String phone);
    UserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO);
    UserResponseDTO updateUser(Long id, UpdateUserRequestDTO updateUserRequestDTO);
    boolean checkExistedEmail(String email);
    void deleteById(Long id);
}
