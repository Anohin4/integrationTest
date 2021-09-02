package com.example.integrationtest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ResultTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String originalId;
    String name;
    String type;
    @Column(length = 10000)
    String recipe;
    String source;

    public ResultTable(Meals meals) {
        this.originalId = meals.getIdMeal();
        this.name = meals.getStrMeal();
        this.type = "meal";
        this.recipe = meals.getStrInstructions();
        this.source = meals.getStrSource();
    }

    public ResultTable(Drinks drinks) {
        this.originalId = drinks.getIdDrink();
        this.name = drinks.getStrDrink();
        this.type = "drink";
        this.recipe = drinks.getStrInstructions();
        this.source = drinks.getStrImageSource();
    }
}
