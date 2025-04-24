package com.example.demo.entities;
import lombok.*;

//DTO to create/update film data
@Data
public class FilmInput {
    private String title;
    private Byte language_id;
    private String description;
//    private Language language;
}