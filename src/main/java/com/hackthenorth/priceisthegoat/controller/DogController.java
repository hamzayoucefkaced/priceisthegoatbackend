package com.hackthenorth.priceisthegoat.controller;

import com.hackthenorth.priceisthegoat.dal.models.Dog;
import com.hackthenorth.priceisthegoat.dal.service.DogService;
import com.hackthenorth.priceisthegoat.dtos.DogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/dog")
public class DogController {
    private final DogService dogService;

    @PostMapping(path="/add")
    public ResponseEntity<Dog> addDog(@RequestBody DogDTO dogDTO){
        return new ResponseEntity<>(dogService.addDog(dogDTO), HttpStatus.CREATED);
    }

    @GetMapping(path="/{id}/getDogs")
    public ResponseEntity<Set<Dog>> getDogs(@PathVariable long userId){
        return new ResponseEntity<>(dogService.getDogsByUserId(userId), HttpStatus.OK);
    }

}
