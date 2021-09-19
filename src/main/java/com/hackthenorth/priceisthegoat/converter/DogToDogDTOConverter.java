package com.hackthenorth.priceisthegoat.converter;

import com.hackthenorth.priceisthegoat.dal.models.Breed;
import com.hackthenorth.priceisthegoat.dal.models.Dog;
import com.hackthenorth.priceisthegoat.dtos.BreedDTO;
import com.hackthenorth.priceisthegoat.dtos.DogDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DogToDogDTOConverter implements Converter<Dog, DogDTO> {
    @Override
    public DogDTO convert(final Dog dog) {
        return DogDTO.builder()
                     .name(dog.getName())
                     .age(dog.getAge())
                     .id(dog.getId())
                     .breeds(breedConverter(dog.getBreed()))
                     .build();
    }

    private Set<BreedDTO> breedConverter(final Set<Breed> breed) {
        return breed.stream()
                    .map(this::buildBreed)
                    .collect(Collectors.toSet());
    }

    private BreedDTO buildBreed(final Breed breed) {
        return BreedDTO.builder()
                       .name(breed.getName())
                       .size(breed.getSize())
                       .type(breed.getType())
                       .build();
    }
}
