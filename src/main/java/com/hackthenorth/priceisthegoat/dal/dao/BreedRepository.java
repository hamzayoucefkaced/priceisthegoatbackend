package com.hackthenorth.priceisthegoat.dal.dao;

import com.hackthenorth.priceisthegoat.dal.models.Breed;
import org.springframework.data.repository.CrudRepository;

public interface BreedRepository extends CrudRepository<Breed, String> {
}

