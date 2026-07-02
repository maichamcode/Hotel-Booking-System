package user_service.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user_service.dto.request.CreateUserRequestDTO;
import user_service.dto.response.UserResponseDTO;
import user_service.entity.UserEntity;
import user_service.enums.Status;
import user_service.exception.EmailAlreadyExistsException;
import user_service.mapper.UserMapper;
import user_service.repo.UserRepo;
import user_service.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO) {
        // check email
        if(userRepo.existsByEmail(createUserRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException(createUserRequestDTO.getEmail());
        }

        UserEntity userEntity = userMapper.toEntity(createUserRequestDTO);
        userEntity.setStatus(Status.ACTIVE);
        userRepo.save(userEntity);

        return userMapper.toResponseDto(userEntity);
    }

    @Override
    public boolean checkExistedEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
