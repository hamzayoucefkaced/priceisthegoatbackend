package com.hackthenorth.priceisthegoat.controller;

import com.hackthenorth.priceisthegoat.dal.service.UserService;
import com.hackthenorth.priceisthegoat.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable final long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.ACCEPTED);
    }
}
