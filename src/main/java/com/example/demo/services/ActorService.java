package com.example.demo.services;

import com.example.demo.entities.Actor;
import com.example.demo.entities.ActorInput;
import com.example.demo.entities.ActorResponse;
import com.example.demo.entities.TestActorResponse;
import com.example.demo.repositories.ActorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public List<TestActorResponse> getAllTestActors() {
        return actorRepository.findAll().stream()
                .map(TestActorResponse::new)
                .toList();
    }

    public Actor createActor(ActorInput data) {
        Actor actor = new Actor();
        actor.setFirstName(data.getFirstName());
        actor.setLastName(data.getLastName());
        return actorRepository.save(actor);
    }

    public Actor getActorById(Short id) {
        return actorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found"));
        //.get()
    }

    public Actor updateActor(Short id, ActorInput data) {
        Actor actor = actorRepository.findById(id).get();
        actor.setFirstName(data.getFirstName());
        actor.setLastName(data.getLastName());
        return actorRepository.save(actor);
    }

    public void deleteActor(Short id) {
        actorRepository.deleteById(id);
    }

//    public List<Film> getFilmsByActorId(Short id) {
//        Actor actor = actorRepository.findById(id).get();
//        return actor.getFilms();
//    }

    public List<ActorResponse> readAllActors() {
        return actorRepository.findAll().stream()
                .map(ActorResponse::new)
                .toList();
    }

    public ActorResponse readActorFilmsById(Short id) {
        return actorRepository.findById(id)
                .map(ActorResponse::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }



    public List<TestActorResponse> getActorsByFirstName(String name) {
        return actorRepository.findAllByFirstName(name).stream()
                .map(TestActorResponse::new)
                .toList();
    }

    public List<TestActorResponse> getActorsByFirstNameCase(String name) {
        return actorRepository.findAllByFirstNameContainsIgnoreCase(name).stream()
                .map(TestActorResponse::new)
                .toList();
    }

    public List<TestActorResponse> getActorsByFirstNameWithQuery(String name) {
        return actorRepository.findAllByFirstNameWithQuery(name).stream()
                .map(TestActorResponse::new)
                .toList();
    }
}
