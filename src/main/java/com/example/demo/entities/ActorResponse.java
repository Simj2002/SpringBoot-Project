package com.example.demo.entities;
import lombok.Getter;
import java.util.List;

//Read-only DTO - transfers Actor entity into a response object for users
@Getter
public class ActorResponse {
    private final Short id;
    private final String firstName;
    private final String lastName;
    private final List<PartialFilmResponse> films;//DTO

    public ActorResponse(Actor actor) {
        this.id = actor.getId();
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
        //Make each film into a partialfilmresponse DTO
        this.films = actor.getFilms()
                .stream()
                .map(PartialFilmResponse::new)
                .toList();
    }
}






//public class ActorResponse {
//    private final Short id;
//    private final String firstName;
//    private final String lastName;
//    private final List<Film> films;
//
//    public ActorResponse(Actor actor) {
//        this.id = actor.getId();
//        this.firstName = actor.getFirstName();
//        this.lastName = actor.getLastName();
//        this.films = actor.getFilms();
//    }
//}