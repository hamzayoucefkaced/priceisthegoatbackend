package com.hackthenorth.priceisthegoat.dtos;

import com.hackthenorth.priceisthegoat.dal.models.Breed;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class DogDTO {
    public String name;
    public int age;
    public Set<Breed> breeds;
}
