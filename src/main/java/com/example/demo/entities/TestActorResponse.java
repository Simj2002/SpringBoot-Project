package com.example.demo.entities;

import lombok.Getter;

//Read-only DTO - transfers actor entity into a response object for users
//Only necessary fields selected
@Getter
public class TestActorResponse {
    private final Short id;
    private final String firstName;
    private final String lastName;

    public TestActorResponse(Actor actor) {
        this.id = actor.getId();
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
    }
}