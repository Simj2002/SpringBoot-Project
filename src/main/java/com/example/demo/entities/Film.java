package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//lombok annotations
@Getter
@Setter
@Entity
@Table(name="film")
public class Film {
    //primary key for film table, with title/description column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Short id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    //Define many-to-many relationship with actor entity
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToMany(mappedBy = "films")
    private List<Actor> cast = new ArrayList<>();
}