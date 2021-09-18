package com.hackthenorth.priceisthegoat.converter;


import com.hackthenorth.priceisthegoat.dal.models.User;
import com.hackthenorth.priceisthegoat.dtos.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserToUserDTOConverter implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(final User user) {
        return UserDTO.builder()
                      .id(user.getId())
                      .email(user.getEmail())
                      .username(user.getUsername())
                      .firstName(user.getFirstName())
                      .lastName(user.getLastName())
                      .isEnabled(user.isEnabled())
                      .build();
    }
}
