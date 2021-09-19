package com.hackthenorth.priceisthegoat.dal.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dog {
    @Id
    @GeneratedValue
    private Long   id;
    private String name;
    private int age;
    @OneToMany
    private Set<Breed> breed;
}
