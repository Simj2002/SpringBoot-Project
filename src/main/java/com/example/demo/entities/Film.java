package com.example.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Short id;
    @Column(name = "title")
    private String title;

    //@Column(name = "language_id")
    //private Byte language_id;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToMany(mappedBy = "films")
    private List<Actor> cast = new ArrayList<>();
}