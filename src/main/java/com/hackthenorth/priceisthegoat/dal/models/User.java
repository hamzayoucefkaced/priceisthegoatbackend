package com.hackthenorth.priceisthegoat.dal.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long   id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;

    private String  password;
    private String  firstName;
    private String  lastName;
    private boolean isEnabled;
}
