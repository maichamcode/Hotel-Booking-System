package user_service.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user_service.dto.request.CreateUserRequestDTO;
import user_service.dto.request.UpdateUserRequestDTO;
import user_service.dto.response.UserResponseDTO;
import user_service.entity.UserEntity;
import user_service.enums.Status;
import user_service.exception.EmailAlreadyExistsException;
import user_service.exception.UserNotFoundException;
import user_service.mapper.UserMapper;
import user_service.repo.UserRepo;
import user_service.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDTO> findAll() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toResponseDto)
                .toList();
    }

    @Override
    public UserResponseDTO findById(Long userId) {
        UserEntity user = userRepo.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(userId));
        return userMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDTO findByEmail(String email) {
        UserEntity user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
        return userMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDTO findByPhoneNumber(String phone) {
        UserEntity user = userRepo.findByPhoneNumber(phone)
                .orElseThrow(() -> new UserNotFoundException(phone));
        return userMapper.toResponseDto(user);
    }

    @Override
    @Transactional
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
    @Transactional
    public UserResponseDTO updateUser(Long id, UpdateUserRequestDTO updateUserRequestDTO) {
        UserEntity user = userRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
        userMapper.updateUser(updateUserRequestDTO, user);
        return userMapper.toResponseDto(user);
    }

    @Override
    public boolean checkExistedEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        UserEntity user = userRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
        userRepo.delete(user);
    }
}
