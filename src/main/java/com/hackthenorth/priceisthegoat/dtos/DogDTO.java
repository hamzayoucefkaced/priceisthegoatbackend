package com.hackthenorth.priceisthegoat.dtos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Builder
@Getter
@Setter
@EqualsAndHashCode
// this will be used for when we send nested dtos from the frontend
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
public class DogDTO {
    private long          id;
    private String        name;
    private int           age;
    private Set<BreedDTO> breeds;
}
