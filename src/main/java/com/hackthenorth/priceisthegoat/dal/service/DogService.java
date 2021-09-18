package com.hackthenorth.priceisthegoat.dal.service;

import com.hackthenorth.priceisthegoat.converter.DogDTOToDogConverter;
import com.hackthenorth.priceisthegoat.dal.dao.DogRepository;
import com.hackthenorth.priceisthegoat.dal.models.Dog;
import com.hackthenorth.priceisthegoat.dtos.DogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DogService {
    private UserService userService;
    private DogRepository dogRepository;
    private DogDTOToDogConverter dogDTOToDogConverter;

    public Dog addDog(DogDTO dogDTO){
        Dog dog = dogDTOToDogConverter.convert(dogDTO);
        dog.setUser(userService.getUserFromContext());
        dogRepository.save(dog);
        return dog;
    }

    public Set<Dog> getDogsByUserId(long id){
        return dogRepository.findAllByUserId(id).orElse(Set.of());
    }
}
