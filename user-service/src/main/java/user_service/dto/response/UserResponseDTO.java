package user_service.dto.response;

import lombok.Data;
import user_service.enums.Status;

@Data
public class UserResponseDTO{
    private String id;
    private String email;
    private String phoneNumber;
    private Status status;
}
