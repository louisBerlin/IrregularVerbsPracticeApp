package org.louis.backend.controller;

import lombok.RequiredArgsConstructor;
import org.louis.backend.dto.UserWOUserId;
import org.louis.backend.model.user.UserRole;
import org.louis.backend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService mongoAuthUserDetailService;


    @GetMapping("/newuser")
    public String newUser() {
        return mongoAuthUserDetailService.addUser(new UserWOUserId("hello@hello.com","bob2","mypass", Set.of(new UserRole()))).toString();
    }






}
