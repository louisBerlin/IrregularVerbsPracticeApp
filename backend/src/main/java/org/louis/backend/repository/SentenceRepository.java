package org.louis.backend.repository;

import org.louis.backend.model.Progression;
import org.louis.backend.model.Sentence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SentenceRepository extends MongoRepository<Sentence,String> {
   // Sentence findSentenceByVerbId(String verbId);

    // find one randoms sentence by verbId
    Sentence findTopByVerbId(String verbId);

    // find one unique sentence randoms sentence by verbId
    Sentence findFirstByVerbId(String verbId);




}
