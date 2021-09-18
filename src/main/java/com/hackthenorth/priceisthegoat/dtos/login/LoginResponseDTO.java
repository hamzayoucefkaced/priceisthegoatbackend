package com.hackthenorth.priceisthegoat.dtos.login;

import com.hackthenorth.priceisthegoat.dtos.UserDTO;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginResponseDTO {
    private String  token;
    private UserDTO user;
}

