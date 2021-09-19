package com.hackthenorth.priceisthegoat.converter;


import com.hackthenorth.priceisthegoat.dal.models.Breed;
import com.hackthenorth.priceisthegoat.dal.models.Dog;
import com.hackthenorth.priceisthegoat.dal.models.User;
import com.hackthenorth.priceisthegoat.dtos.BreedDTO;
import com.hackthenorth.priceisthegoat.dtos.DogDTO;
import com.hackthenorth.priceisthegoat.dtos.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserToUserDTOConverter implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(final User user) {
        return UserDTO.builder()
                      .id(user.getId())
                      .email(user.getEmail())
                      .username(user.getUsername())
                      .firstName(user.getFirstName())
                      .lastName(user.getLastName())
                      .isEnabled(user.isEnabled())
                      .dogs(convertDogs(user.getDogs()))
                      .build();
    }

    public Set<DogDTO> convertDogs(final Set<Dog> dogs) {
        return dogs.stream()
                   .map(this::convertDog)
                   .collect(Collectors.toSet());
    }

    private DogDTO convertDog(final Dog dog) {
        return DogDTO.builder()
                     .name(dog.getName())
                     .breeds(convertBreeds(dog.getBreed()))
                     .age(dog.getAge())
                     .id(dog.getId())
                     .build();
    }

    private Set<BreedDTO> convertBreeds(final Set<Breed> breeds) {
        return breeds.stream()
                     .map(this::convertBreed)
                     .collect(Collectors.toSet());
    }

    private BreedDTO convertBreed(final Breed breed) {
        return BreedDTO.builder()
                       .type(breed.getType())
                       .name(breed.getName())
                       .size(breed.getSize())
                       .build();
    }
}
