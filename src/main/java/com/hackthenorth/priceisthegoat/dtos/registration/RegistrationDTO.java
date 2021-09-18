package com.hackthenorth.priceisthegoat.dtos.registration;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationDTO {
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String matchingPassword;
}
