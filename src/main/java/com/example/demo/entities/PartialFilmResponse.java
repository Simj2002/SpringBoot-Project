package com.example.demo.entities;

import lombok.Getter;

import java.time.Year;

@Getter
public class PartialFilmResponse {
    private final Short id;
    private final String title;
    private final String language;
//    private final Year releaseYear;

    public PartialFilmResponse(Film film) {
        this.id = film.getId();
        this.title = film.getTitle();
        this.language = film.getLanguage().getName();
    }
}
