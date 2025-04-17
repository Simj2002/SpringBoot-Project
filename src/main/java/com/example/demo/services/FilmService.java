package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.repositories.FilmRepository;
import com.example.demo.repositories.LanguageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private LanguageRepository languageRepository;

    public List<PartialFilmResponse> getAllFilms() {
        return filmRepository.findAll()
                .stream()
                .map(PartialFilmResponse::new)
                .toList();
    }

    public PartialFilmResponse getFilmById(Short id) {
        Film film = filmRepository.findById(id).get();
        return new PartialFilmResponse(film);
    }

    public Film createFilm(FilmInput data) {
//        Film film = new Film();
//        film.setTitle(data.getTitle());
//        Language language = new Language();
//        language.setId(data.getLanguage().getId());
//        film.setLanguage(language);
//        return filmRepository.save(film);

        Film film = new Film();
        film.setTitle(data.getTitle());
        Language language = languageRepository.findById(data.getLanguage_id())
                .orElseThrow(() -> new RuntimeException("Language not found"));
        film.setLanguage(language);
        return filmRepository.save(film);
    }

    public Film updateFilm(Short id, FilmInput data) {
//        Film film = filmRepository.findById(id).get();
//        film.setTitle(data.getTitle());
//        Language language = new Language();
//        language.setId(data.getLanguage().getId());
//        film.setLanguage(language);
//        return filmRepository.save(film);

        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        film.setTitle(data.getTitle());
        Language language = languageRepository.findById(data.getLanguage_id())
                .orElseThrow(() -> new RuntimeException("Language not found"));
        film.setLanguage(language);
        return filmRepository.save(film);
    }

    public void deleteFilm(Short id) {
        filmRepository.deleteById(id);
    }

    public List<TestActorResponse> getCastByFilmId(Short filmId) {
        Film film = filmRepository.findById(filmId).get();
        return film.getCast()
                .stream()
                .map(TestActorResponse::new)
                .toList();
    }
}
