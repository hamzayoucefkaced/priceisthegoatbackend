package com.hackthenorth.priceisthegoat.dal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Breed {
    @Id
    private String name;
    @Enumerated(EnumType.STRING)
    private Group type;
    private int  height;
    private int  weight;
    private enum Group {
        Sporting, Hound, Working, Terrier, Toy, NonSporting, Herding;
    }
}
