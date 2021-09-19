package com.hackthenorth.priceisthegoat.dal.service;

import com.hackthenorth.priceisthegoat.converter.DogDTOToDogConverter;
import com.hackthenorth.priceisthegoat.dal.dao.DogRepository;
import com.hackthenorth.priceisthegoat.dal.models.Dog;
import com.hackthenorth.priceisthegoat.dal.models.User;
import com.hackthenorth.priceisthegoat.dal.service.exceptions.HTNNotFoundException;
import com.hackthenorth.priceisthegoat.dtos.DogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DogService {
    private final UserService          userService;
    private final DogRepository        dogRepository;
    private final DogDTOToDogConverter dogDTOToDogConverter;
    private final ConversionService    mvcConversionService;

    public Dog addDog(final DogDTO dogDTO) {
        final User user = userService.getUserFromContext();
        final Dog  dog  = dogDTOToDogConverter.convert(dogDTO);
        user.getDogs().add(dog);

        dogRepository.save(dog);
        userService.saveUser(user);

        return dog;
    }

    public DogDTO getDog(final long id) {
        return mvcConversionService.convert(dogRepository.findById(id)
                                                         .orElseThrow(() -> new HTNNotFoundException(String.format("No dog with id: %d in the db", id))),
                                            DogDTO.class);
    }
}
