package com.melck.carrertoolms.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.melck.carrertoolms.entities.User;
import com.melck.carrertoolms.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
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
    @NotNull(message = "Este campo é obrigatório")
    private Gender gender;
    @NotBlank(message = "Este campo é obrigatório")
    private String phoneNumber;

    @NotBlank(message = "Este campo é obrigatório")
    @Email
    private String email;
    @NotBlank(message = "Este campo é obrigatório")
    @Size(min = 8, max = 8, message = "A senha deve conter 8 digitos")
    private String password;

    private int age;


    public UserDTO(User user) {
        this.userId = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
        this.gender = user.getGender();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
