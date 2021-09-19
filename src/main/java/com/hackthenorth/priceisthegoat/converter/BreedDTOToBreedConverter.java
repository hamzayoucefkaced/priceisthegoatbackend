package com.hackthenorth.priceisthegoat.converter;

import com.hackthenorth.priceisthegoat.dtos.BreedDTO;
import com.hackthenorth.priceisthegoat.dal.models.Breed;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class BreedDTOToBreedConverter implements Converter<BreedDTO, Breed> {

    @Override
    public Breed convert(BreedDTO breedDTO) {
        return Breed.builder().name(breedDTO.name).size(breedDTO.size).type(breedDTO.type).build();
    }
}
