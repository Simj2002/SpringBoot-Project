package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//lombok annotations
@Getter
@Setter
@Entity
@Table(name = "language")
public class Language {
    //primary key for language table, with language name column
    @Id
    @Column(name = "language_id")
    private Byte id;

    @Column(name = "name")
    private String name;
}
