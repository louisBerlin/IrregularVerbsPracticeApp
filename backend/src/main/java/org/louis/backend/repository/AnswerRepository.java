package org.louis.backend.repository;


import org.louis.backend.model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends MongoRepository<Answer,String> {

    Answer findByUserIdAndVerbId(String userId, String id);

    List<Answer> findByUserId(String userId);





}
