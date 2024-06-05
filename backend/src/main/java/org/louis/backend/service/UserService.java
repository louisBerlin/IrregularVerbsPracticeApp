package org.louis.backend.service;

import lombok.RequiredArgsConstructor;
import org.louis.backend.dto.MongoUserDto;
import org.louis.backend.dto.UserWOUserId;
import org.louis.backend.model.user.MongoUser;
import org.louis.backend.repository.MongoUserRepo;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
 public class UserService implements UserDetailsService {



    private final MongoUserRepo repo;

    private Argon2PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MongoUser user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + username + " not found!"));
        return new User(user.username(), user.password(), Collections.emptyList());
    }

    public void saveNewUser(MongoUserDto newUser) {
        MongoUser user = MongoUser.builder()
                .id(UUID.randomUUID().toString())
                .username(newUser.username())
                .password(encoder.encode(newUser.password()))
                .build();
        repo.save(user);
    }










}