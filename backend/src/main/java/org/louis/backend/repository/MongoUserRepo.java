package org.louis.backend.repository;

import org.louis.backend.model.user.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoUserRepo extends MongoRepository<MongoUser, String> {

   /* @Query("{username:'?0'}")
    MongoUser findUserByUsername(String username);

    */

    Optional<MongoUser> findByUsername(String username);





}