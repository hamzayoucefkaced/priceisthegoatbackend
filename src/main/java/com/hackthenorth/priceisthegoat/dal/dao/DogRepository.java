package com.hackthenorth.priceisthegoat.dal.dao;

import com.hackthenorth.priceisthegoat.dal.models.Dog;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface DogRepository extends CrudRepository<Dog, String> {
    Optional<Dog> findByName(String name);

    Optional<Dog> findByAge(int age);

    Optional<Set<Dog>> findAllByUserId(long id);
    }

