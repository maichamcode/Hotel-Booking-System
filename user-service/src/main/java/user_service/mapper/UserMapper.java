package user_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import user_service.dto.request.CreateUserRequestDTO;
import user_service.dto.request.UpdateUserRequestDTO;
import user_service.dto.response.UserResponseDTO;
import user_service.entity.UserEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserEntity toEntity(CreateUserRequestDTO createUserRequestDTO);
    void updateUser(UpdateUserRequestDTO updateUserRequestDTO, @MappingTarget UserEntity userEntity);
    UserResponseDTO toResponseDto(UserEntity userEntity);
}
