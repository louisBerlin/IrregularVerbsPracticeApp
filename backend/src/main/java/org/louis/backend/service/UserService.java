package org.louis.backend.service;

import lombok.RequiredArgsConstructor;
import org.louis.backend.dto.UserWOUserId;
import org.louis.backend.model.user.User;
import org.louis.backend.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
 public class UserService implements UserDetailsService {
    private  final UserRepository userRepository;


    public User addUser (UserWOUserId userWOUserId) {
        if(userRepository.findUserByEmailAndUsername(userWOUserId.getEmail(), userWOUserId.getUsername())==null)
            return userRepository.save(new User(null,userWOUserId.getUsername(),userWOUserId.getEmail(),userWOUserId.getPassword(),userWOUserId.getUserRoles()));
        else return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }








}