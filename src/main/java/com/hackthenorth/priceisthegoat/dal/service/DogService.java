package com.hackthenorth.priceisthegoat.dal.service;

import com.hackthenorth.priceisthegoat.converter.DogDTOToDogConverter;
import com.hackthenorth.priceisthegoat.dal.dao.DogRepository;
import com.hackthenorth.priceisthegoat.dal.dao.UserRepository;
import com.hackthenorth.priceisthegoat.dal.models.Dog;
import com.hackthenorth.priceisthegoat.dal.models.User;
import com.hackthenorth.priceisthegoat.dtos.DogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DogService {
    private final UserService userService;
    private final DogRepository dogRepository;
    private final DogDTOToDogConverter dogDTOToDogConverter;

    public Dog addDog(DogDTO dogDTO){
        User user = userService.getUserFromContext();
        Dog dog = dogDTOToDogConverter.convert(dogDTO);
        user.getDogs().add(dog);

        dogRepository.save(dog);
        userService.saveUser(user);

        return dog;
    }
}
