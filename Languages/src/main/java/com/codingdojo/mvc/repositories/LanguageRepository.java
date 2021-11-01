package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.codingdojo.mvc.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
    // this method retrieves all the languages from the database
    List<Language> findAll();

}
