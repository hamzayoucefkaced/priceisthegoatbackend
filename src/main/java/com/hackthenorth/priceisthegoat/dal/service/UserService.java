package com.hackthenorth.priceisthegoat.dal.service;

import com.hackthenorth.priceisthegoat.configurations.HTNUserDetailService;
import com.hackthenorth.priceisthegoat.configurations.HTNUserDetails;
import com.hackthenorth.priceisthegoat.dal.dao.UserRepository;
import com.hackthenorth.priceisthegoat.dal.models.User;
import com.hackthenorth.priceisthegoat.dal.service.exceptions.ExceptionHelper;
import com.hackthenorth.priceisthegoat.dal.service.exceptions.HTNNotFoundException;
import com.hackthenorth.priceisthegoat.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ConversionService mvcConversionService;
    private final UserRepository    userRepository;
    private final HTNUserDetailService htnUserDetailService;

    public User getUserFromContext() {
        final HTNUserDetails details = (HTNUserDetails) htnUserDetailService.loadUserByUsername((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return handleGetByUsername(details.getUsername());
    }

    public UserDTO createUser(final User user) {
        return mvcConversionService.convert(userRepository.save(user), UserDTO.class);
    }

    public UserDTO getUser(final long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new HTNNotFoundException(String.format("User with user id: %d does not exist!", id)));
        return mvcConversionService.convert(user, UserDTO.class);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public boolean usernameExists(final String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public boolean emailExists(final String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public UserDTO toggleAccountActivation(final User user) {
        user.setEnabled(!user.isEnabled());
        return mvcConversionService.convert(userRepository.save(user), UserDTO.class);
    }

    private User handleGetByUsername(final String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new HTNNotFoundException(ExceptionHelper.getNotFoundExceptionMessage("Username", username)));
    }

    public UserDTO getUserByUsername(final String username) {
        return mvcConversionService.convert(handleGetByUsername(username), UserDTO.class);
    }
}
