package com.example.demo.repositories;

import com.example.demo.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Short> {
    List<Actor> findAllByFirstName(String firstName);
    List<Actor> findAllByFirstNameContainsIgnoreCase(String firstName);
    @Query("select a from Actor a where a.firstName = ?1")
    List<Actor> findAllByFirstNameWithQuery(String firstName);
}
// mockito