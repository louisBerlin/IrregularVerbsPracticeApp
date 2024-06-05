package org.louis.backend.repository;


import org.louis.backend.model.Progression;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProgressionRepository extends MongoRepository<Progression,String>{

    Progression findByUserId(String userId);

    List<Progression> findAllByUserId(String userId);

    Progression findTopByUserIdOrderByTimestampDesc(String userId);



}
