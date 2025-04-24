package com.example.demo.entities;

import lombok.Getter;

//Read-only DTO - transfers film entity into a response object for users
//Only necessary fields selected
@Getter
public class PartialFilmResponse {
    private final Short id;
    private final String title;
    private final String language;
    private final String description;

    public PartialFilmResponse(Film film) {
        this.id = film.getId();
        this.title = film.getTitle();
        this.language = film.getLanguage().getName();
        this.description = film.getDescription();
    }
}
