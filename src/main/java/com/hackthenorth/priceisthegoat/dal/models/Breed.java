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
    @Enumerated(EnumType.STRING)
    private Size size;
    private enum Group {
        Sporting, Hound, Working, Terrier, Toy, NonSporting, Herding,
    }
    private enum Size {
        Large, Medium, Small;
    }
}
