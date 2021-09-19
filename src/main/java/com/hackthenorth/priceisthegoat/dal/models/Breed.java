package com.hackthenorth.priceisthegoat.dal.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Breed {
    @Id
    private String name;
    @Enumerated(EnumType.STRING)
    private Group type;
    @Enumerated(EnumType.STRING)
    private Size size;

    public enum Group {
        @JsonProperty("Sporting") Sporting,
        @JsonProperty("Hound") Hound,
        @JsonProperty("Working") Working,
        @JsonProperty("Terrier") Terrier,
        @JsonProperty("Toy") Toy,
        @JsonProperty("NonSporting") NonSporting,
        @JsonProperty("Herding") Herding,
        @JsonProperty("Mixed") Mixed;
    }

    public enum Size {
        @JsonProperty("Large") Large,
        @JsonProperty("Medium") Medium,
        @JsonProperty("Small") Small;
    }
}
