package com.hackthenorth.priceisthegoat.dtos.login;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDTO {
    private String username;
    private String password;
}
