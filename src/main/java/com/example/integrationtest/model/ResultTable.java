package com.example.integrationtest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResultTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String originalId;
    String name;
    String type;
    String recipe;
    String source;

}
