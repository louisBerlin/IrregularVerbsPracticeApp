package org.louis.backend.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.louis.backend.dto.MongoUserDto;
import org.louis.backend.dto.UserWOUserId;
import org.louis.backend.model.user.UserRole;
import org.louis.backend.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService service;

    @GetMapping("/me")
    public String getMe2(Principal principal){
        if (principal != null) {
            return principal.getName();
        }
        return "anonymousUser";
    }

    @GetMapping
    public String getMe(){
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }

    @PostMapping("/register")
    public void register(@RequestBody MongoUserDto newUser){
        service.saveNewUser(newUser);
    }

    @PostMapping("/login")
    public String login(){
        System.out.println("login");
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }

    @GetMapping("/logout")
    public void logout(HttpSession session){
        System.out.println("logout");
        session.invalidate();
        SecurityContextHolder.clearContext();
    }


    /*
    private final UserService mongoAuthUserDetailService;
    @GetMapping("/newuser")
    public String newUser() {
        return mongoAuthUserDetailService.addUser(new UserWOUserId("hello@hello.com","bob2","mypass", Set.of(new UserRole()))).toString();
    }
     */
}
