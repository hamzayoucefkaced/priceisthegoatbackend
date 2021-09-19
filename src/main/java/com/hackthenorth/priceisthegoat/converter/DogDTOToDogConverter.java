package com.hackthenorth.priceisthegoat.converter;

import com.hackthenorth.priceisthegoat.dal.models.Breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import com.hackthenorth.priceisthegoat.dal.models.Dog;
import com.hackthenorth.priceisthegoat.dtos.DogDTO;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DogDTOToDogConverter implements Converter<DogDTO, Dog> {

    @Autowired
    private BreedDTOToBreedConverter breedDTOToBreedConverter;

    @Override
    public Dog convert(DogDTO dogDTO) {
        Set<Breed> breeds = dogDTO.breeds.stream().map(breedDTOToBreedConverter::convert).collect(Collectors.toSet());
        return Dog.builder().age(dogDTO.age).breed(breeds).name(dogDTO.name).build();
    }
}
