package com.hackthenorth.priceisthegoat.converter;


import com.hackthenorth.priceisthegoat.dal.models.User;
import com.hackthenorth.priceisthegoat.dtos.registration.RegistrationDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class RegistrationDTOToUserConverter implements Converter<RegistrationDTO, User> {

    @Override
    public User convert(final RegistrationDTO registrationDTO) {
        return User.builder()
                   .email(registrationDTO.getEmail())
                   .username(registrationDTO.getUsername())
                   .password(registrationDTO.getPassword())
                   .firstName(registrationDTO.getFirstName())
                   .lastName(registrationDTO.getLastName())
                   .build();
    }
}
