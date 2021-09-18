package com.hackthenorth.priceisthegoat.dal.models;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "confirmation_tokens")
public class ConfirmationToken {
    @Id
    @GeneratedValue
    private long   id;
    private String confirmationToken;
    private Date   dateCreated;
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User   user;

    public ConfirmationToken(final User user) {
        this.user         = user;
        dateCreated       = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }
}
