package com.hackthenorth.priceisthegoat.dal.dao;

import com.hackthenorth.priceisthegoat.dal.models.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
