package com.example.demo.entities;

import lombok.Getter;

@Getter
public class LanguageResponse {
    private final Byte id;
    private final String name;

    public LanguageResponse(Language language) {
        this.id = language.getId();
        this.name = language.getName();
    }
}
