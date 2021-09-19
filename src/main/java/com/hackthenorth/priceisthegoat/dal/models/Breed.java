package com.hackthenorth.priceisthegoat.dal.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

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
        @JsonProperty("Sporting") SPORTING,
        @JsonProperty("Hound") HOUND,
        @JsonProperty("Working") WORKING,
        @JsonProperty("Terrier") TERRIER,
        @JsonProperty("Toy") TOY,
        @JsonProperty("NonSporting") NONSPORTING,
        @JsonProperty("Herding") HERDING,
        @JsonProperty("Mixed") MIXED;
    }

    public enum Size {
        @JsonProperty("Large") LARGE,
        @JsonProperty("Medium") MEDIUM,
        @JsonProperty("Small") SMALL;
    }
}
