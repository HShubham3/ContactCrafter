package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    @NotBlank(message = "Username is required.")
    private String name;

    @Email(message = "Invalid Email Address.")
    @NotBlank(message = "Email is Required")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Minimum 6 character is required.")
    private String password;

    @NotBlank(message = "About is required")
    private String about;
    @Size(min = 10, max = 10, message = "Invalid Phone Number.")
    private String phoneNumber;

}
