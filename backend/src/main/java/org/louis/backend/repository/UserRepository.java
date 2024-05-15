package org.louis.backend.repository;

import org.louis.backend.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{username:'?0'}")
    User findUserByUsername(String username);



    public User findUserByEmailAndUsername (String email, String username);

}