package com.hackthenorth.priceisthegoat.dtos;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class UserDTO {
    private Long        id;
    private String      username;
    private String      email;
    private String      firstName;
    private String      lastName;
    private boolean     isEnabled;
    private Set<DogDTO> dogs;
}