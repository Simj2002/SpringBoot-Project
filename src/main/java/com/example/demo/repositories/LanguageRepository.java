package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository for managing language entities
@Repository
public interface LanguageRepository extends JpaRepository<Language, Byte> {

}
