package com.example.demo.repositories;

import com.example.demo.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository for managing film entities
public interface FilmRepository extends JpaRepository<Film, Short> {

    Short id(Short id);
}
