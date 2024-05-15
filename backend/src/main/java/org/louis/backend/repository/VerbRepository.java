package org.louis.backend.repository;


import org.louis.backend.model.Verb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerbRepository extends MongoRepository <Verb, String> {


    List<Verb> findAll ();


}
