package com.hackthenorth.priceisthegoat.dal.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Dog> dogs;
}
