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

//Make sure class is a Spring service and methods are transactional
@Service
@Transactional
public class ActorService {
    //inject ActorRepository
    @Autowired
    private ActorRepository actorRepository;

    //Retrieve actor data and map to TestActorResponse
    public List<TestActorResponse> getAllTestActors() {
        return actorRepository.findAll().stream()
                .map(TestActorResponse::new)
                .toList();
    }

    //Create actor entity from inputs and save to database
    public Actor createActor(ActorInput data) {
        Actor actor = new Actor();
        actor.setFirstName(data.getFirstName());
        actor.setLastName(data.getLastName());
        return actorRepository.save(actor);
    }

    //Retrieve actor by certain id
    public Actor getActorById(Short id) {
        return actorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found"));
        //.get()
    }

    //Update actor entity and save to database
    public Actor updateActor(Short id, ActorInput data) {
        Actor actor = actorRepository.findById(id).get();
        actor.setFirstName(data.getFirstName());
        actor.setLastName(data.getLastName());
        return actorRepository.save(actor);
    }

    //Delete actor from database by id
    public void deleteActor(Short id) {
        actorRepository.deleteById(id);
    }

    //Read actor and map to actor response
    public List<ActorResponse> readAllActors() {
        return actorRepository.findAll().stream()
                .map(ActorResponse::new)
                .toList();
    }

    //Read actor and their films
    public ActorResponse readActorFilmsById(Short id) {
        return actorRepository.findById(id)
                .map(ActorResponse::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //Query services below
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
