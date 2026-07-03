package user_service.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequestDTO {
    @NotBlank
    private String firstName;
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;
    @Size(min = 8, max = 100)
    private String password;
}
