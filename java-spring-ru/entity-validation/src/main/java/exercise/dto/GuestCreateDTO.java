package exercise.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// BEGIN
@Setter
@Getter
public class GuestCreateDTO {
    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^\\+[0-9]{11,13}$")
    private String phoneNumber;

    @NotNull
    @Size(min = 4, max = 4)
    @PositiveOrZero
    private String clubCard;

    @Future(message = "Card has expired")
    private LocalDate cardValidUntil;
}
// END
