package com.example.demo.controllers;

import com.example.demo.entities.*;
import com.example.demo.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;
    //private FilmRepository filmRepository;

//    @GetMapping("/films")
//    public List<Film> getAllFilms() {
//        return filmRepository.findAll();
//    }
//
//    @GetMapping("/films/{id}")
//    public Film findFilm(@PathVariable Short id) {
//        return filmRepository.findById(id).get();
//    }
//
//    @PostMapping("/films")
//    public Film create(@RequestBody FilmInput data) {
//        final var film = new Film();
//        film.setTitle(data.getTitle());
//        film.setLanguage(data.getLanguage());
//        return filmRepository.save(film);
//    }
//
//    @PutMapping("/films/{id}")
//    public Film updateFilm(@PathVariable Short id, @RequestBody FilmInput data) {
//        Film film = filmRepository.findById(id).get();
//        film.setTitle(data.getTitle());
//        film.setLanguage(data.getLanguage());
//        return filmRepository.save(film);
//    }
//
//    @DeleteMapping("/films/{id}")
//    public void deleteFilm(@PathVariable Short id) {
//        filmRepository.deleteById(id);
//    }
//
//    @GetMapping("/films/{id}/cast")
//    public List<Actor> getFilmCast(@PathVariable Short id) {
//        Film film = filmRepository.findById(id).get();
//        return film.getCast();
//    }


    @GetMapping("/films")
    public List<PartialFilmResponse> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/films/{id}")
    public PartialFilmResponse findFilm(@PathVariable Short id) {
        return filmService.getFilmById(id);
    }

    @PostMapping("/films")
    public Film create(@RequestBody FilmInput data) {
        return filmService.createFilm(data);
    }

    @PutMapping("/films/{id}")
    public Film updateFilm(@PathVariable Short id, @RequestBody FilmInput data) {
        return filmService.updateFilm(id, data);
    }

    @DeleteMapping("/films/{id}")
    public void deleteFilm(@PathVariable Short id) {
        filmService.deleteFilm(id);
    }

    @GetMapping("/films/{id}/cast")
    public List<TestActorResponse> getFilmCast(@PathVariable Short id) {
        return filmService.getCastByFilmId(id);
    }
}
