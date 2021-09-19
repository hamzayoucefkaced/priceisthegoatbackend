package com.hackthenorth.priceisthegoat.converter;

import com.hackthenorth.priceisthegoat.dal.models.Breed;
import com.hackthenorth.priceisthegoat.dal.models.Dog;
import com.hackthenorth.priceisthegoat.dtos.DogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DogDTOToDogConverter implements Converter<DogDTO, Dog> {

    @Autowired
    private BreedDTOToBreedConverter breedDTOToBreedConverter;

    @Override
    public Dog convert(final DogDTO dogDTO) {
        final Set<Breed> breeds = dogDTO.getBreeds().stream().map(breedDTOToBreedConverter::convert).collect(Collectors.toSet());
        return Dog.builder().age(dogDTO.getAge()).breed(breeds).name(dogDTO.getName()).build();
    }
}
