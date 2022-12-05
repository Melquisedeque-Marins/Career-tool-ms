package com.melck.carrertoolms.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.melck.carrertoolms.entities.User;
import com.melck.carrertoolms.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
    @NotNull(message = "the birth date field cannot be empty")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past(message = "Insira uma data de nascimento valida")
    private LocalDate birthDate;
    private Gender gender;
    private String phoneNumber;
    private String email;
    private String password;


    public UserDTO(User user) {
        this.userId = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
        this.gender = user.getGender();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
    }
}
