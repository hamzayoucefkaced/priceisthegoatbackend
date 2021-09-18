package com.hackthenorth.priceisthegoat.converter;

import org.springframework.core.convert.converter.Converter;
import com.hackthenorth.priceisthegoat.dal.models.Dog;
import com.hackthenorth.priceisthegoat.dtos.DogDTO;
import org.springframework.stereotype.Service;

@Service
public class DogDTOToDogConverter implements Converter<DogDTO, Dog> {

    @Override
    public Dog convert(DogDTO dogDTO) {
        return Dog.builder().age(dogDTO.age).breed(dogDTO.breeds).name(dogDTO.name).build();
    }
}
