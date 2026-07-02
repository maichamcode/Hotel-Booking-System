package user_service.service;

import user_service.dto.request.CreateUserRequestDTO;
import user_service.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO);
    boolean checkExistedEmail(String email);
}
