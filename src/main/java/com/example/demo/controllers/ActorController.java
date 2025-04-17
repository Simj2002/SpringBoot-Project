package com.example.demo.controllers;

import com.example.demo.entities.*;
import com.example.demo.services.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
//@RequestMapping("/actors")
@RestController
public class ActorController {
    @Autowired
    private ActorService actorService;

//    @GetMapping("/actors")
//    public List<Actor> getAllActors() {
//        return actorRepository.findAll();
//    }

//    @GetMapping("/actors")
//    public List<TestActorResponse> getAllActors() {
//        return actorRepository.findAll().stream().map(TestActorResponse::new).toList();
//    }
//
//    @PostMapping("/actors")
//    public Actor create(@Validated @RequestBody ActorInput data) {
//        final var actor = new Actor();
//        actor.setFirstName(data.getFirstName());
//        actor.setLastName(data.getLastName());
//        return actorRepository.save(actor);
//    }
//
//    @GetMapping("/actors/{id}")
//    public Actor findActor(@PathVariable Short id) {
//        return actorRepository.findById(id).get();
//    }
//
//    @PutMapping("/actors/{id}")
//    public Actor updateActor(@PathVariable Short id, @RequestBody ActorInput data) {
//        Actor actor = actorRepository.findById(id).get();
//        actor.setFirstName(data.getFirstName());
//        actor.setLastName(data.getLastName());
//        return actorRepository.save(actor);
//    }
//
//    @DeleteMapping("/actors/{id}")
//    public void deleteActor(@PathVariable Short id) {
//        actorRepository.deleteById(id);
//    }
//
//    @GetMapping("/actors/{id}/film")
//    public List<Film> getFilmCast(@PathVariable Short id) {
//        Actor actor = actorRepository.findById(id).get();
//        return actor.getFilms();
//    }
//
////    @GetMapping("/actors")
////    public List<Actor> listActorsByName(@RequestParam String name) {
////        return actorRepository.findAllByFirstName(name);
////    }
//
//    @GetMapping
//    public List<ActorResponse> readAllActors() {
//        return actorRepository.findAll()
//            .stream()
//            .map(ActorResponse::new)
//            .toList();
//    }
//
//    @GetMapping("/actors/film/{id}")
//    public ActorResponse readActorById(@PathVariable Short id) {
//        return actorRepository.findById(id)
//            .map(ActorResponse::new)
//            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }

    @GetMapping("/actors")
    public List<TestActorResponse> getAllActors() {
        return actorService.getAllTestActors();
    }

    @PostMapping("/actors")
    public Actor create(@Validated @RequestBody ActorInput data) {
        return actorService.createActor(data);
    }

    @GetMapping("/actors/{id}")
    public TestActorResponse findActor(@PathVariable Short id) {
        Actor actor = actorService.getActorById(id);
        return new TestActorResponse(actor);
    }

    @PutMapping("/actors/{id}")
    public Actor updateActor(@PathVariable Short id, @RequestBody ActorInput data) {
        return actorService.updateActor(id, data);
    }

    @DeleteMapping("/actors/{id}")
    public void deleteActor(@PathVariable Short id) {
        actorService.deleteActor(id);
    }

    @GetMapping
    public List<ActorResponse> readAllActors() {
        return actorService.readAllActors();
    }

    @GetMapping("/actors/film/{id}")
    public ActorResponse readActorById(@PathVariable Short id) {
        return actorService.readActorFilmsById(id);
    }

    //http://localhost:8080/api/actors/firstname?name=pen
    @GetMapping("/actors/firstname")
    public List<TestActorResponse> getActorsByFirstName(@RequestParam String name) {
        return actorService.getActorsByFirstName(name);
    }

    //http://localhost:8080/api/actors/firstnamecase?name=pen
    @GetMapping("/actors/firstnamecase")
    public List<TestActorResponse> searchActorsByName(@RequestParam String name) {
        return actorService.getActorsByFirstNameCase(name);
    }

    //http://localhost:8080/api/actors/query?name=PENELOPE
    @GetMapping("/actors/query")
    public List<TestActorResponse> getActorsByQuery(@RequestParam String name) {
        return actorService.getActorsByFirstNameWithQuery(name);
    }
}