package com.hackthenorth.priceisthegoat.dal.dao;

import com.hackthenorth.priceisthegoat.dal.models.Dog;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DogRepository extends CrudRepository<Dog, Long> {
    Optional<Dog> findByName(String name);

    Optional<Dog> findByAge(int age);
}

