package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.repositories.FilmRepository;
import com.example.demo.repositories.LanguageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//Make sure class is a Spring service and methods are transactional
@Service
@Transactional
public class FilmService {
    //inject filmRepository
    @Autowired
    private FilmRepository filmRepository;

    //inject languageRepository
    @Autowired
    private LanguageRepository languageRepository;

    //Retrieve all films and map to PartialFilmResponse
    public List<PartialFilmResponse> getAllFilms() {
        return filmRepository.findAll()
                .stream()
                .map(PartialFilmResponse::new)
                .toList();
    }

    //Retrieve film by specific id
    public PartialFilmResponse getFilmById(Short id) {
        Film film = filmRepository.findById(id).get();
        return new PartialFilmResponse(film);
    }

    //Map input to a film entity
    public Film createFilm(FilmInput data) {
        Film film = new Film();
        film.setTitle(data.getTitle());
        //Find language by id, otherwise throw exception
        Language language = languageRepository.findById(data.getLanguage_id())
                .orElseThrow(() -> new RuntimeException("Language not found"));
        film.setLanguage(language);
        return filmRepository.save(film);
    }

    //Update a film entity
    public Film updateFilm(Short id, FilmInput data) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        film.setTitle(data.getTitle());
        Language language = languageRepository.findById(data.getLanguage_id())
                .orElseThrow(() -> new RuntimeException("Language not found"));
        film.setLanguage(language);
        return filmRepository.save(film);
    }

    //Delete a film entity
    public void deleteFilm(Short id) {
        filmRepository.deleteById(id);
    }

    //Read film entity and their cast
    public List<TestActorResponse> getCastByFilmId(Short filmId) {
        Film film = filmRepository.findById(filmId).get();
        return film.getCast()
                .stream()
                .map(TestActorResponse::new)
                .toList();
    }
}
