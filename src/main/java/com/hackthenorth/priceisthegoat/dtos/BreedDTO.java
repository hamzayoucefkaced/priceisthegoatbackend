package com.hackthenorth.priceisthegoat.dtos;

import com.hackthenorth.priceisthegoat.dal.models.Breed;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class BreedDTO {
    public String name;
    public Breed.Group type;
    public Breed.Size size;
}
