package com.hackthenorth.priceisthegoat.controller;

import com.hackthenorth.priceisthegoat.dal.models.Dog;
import com.hackthenorth.priceisthegoat.dal.service.DogService;
import com.hackthenorth.priceisthegoat.dtos.DogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/dog")
public class DogController {
    private final DogService dogService;

    @PostMapping(path = "/add")
    public ResponseEntity<Dog> addDog(@RequestBody final DogDTO dogDTO) {
        return new ResponseEntity<>(dogService.addDog(dogDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DogDTO> getDogById(@PathVariable final long id) {
        return new ResponseEntity<>(dogService.getDog(id), HttpStatus.ACCEPTED);
    }
}
