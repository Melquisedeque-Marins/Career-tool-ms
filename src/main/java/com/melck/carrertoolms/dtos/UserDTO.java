package com.melck.carrertoolms.dtos;

import com.melck.carrertoolms.entities.User;
import com.melck.carrertoolms.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userId;

    @NotBlank(message = "Este campo é obrigatório")
    private String firstName;
    @NotBlank(message = "Este campo é obrigatório")
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String phoneNumber;
    private String email;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
        this.gender = user.getGender();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
    }
}
