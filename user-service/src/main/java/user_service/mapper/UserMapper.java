package user_service.mapper;

import org.mapstruct.Mapper;
import user_service.dto.request.CreateUserRequestDTO;
import user_service.dto.response.UserResponseDTO;
import user_service.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(CreateUserRequestDTO createUserRequestDTO);
    UserResponseDTO toResponseDto(UserEntity userEntity);
}
