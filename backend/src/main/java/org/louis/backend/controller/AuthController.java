package org.louis.backend.controller;


import org.louis.backend.dto.BasicUser;
import org.louis.backend.dto.GitHubUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/me")
    public String getMe(@AuthenticationPrincipal OAuth2User defaultOAuth2User) {
        if(defaultOAuth2User == null)
            return "nobody";
        else
            return defaultOAuth2User.getAttributes().get("login").toString();
    }






    @GetMapping("/me2")
    public String getMe(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }



   /* @GetMapping("/me4")
    public BasicUser getMe4(){

        return new BasicUser(SecurityContextHolder.getContext().getAuthentication().,SecurityContextHolder.getContext().getAuthentication().getName())
    }

    */




    @GetMapping("/me3")
    public GitHubUser getMe3(@AuthenticationPrincipal OAuth2User defaultOAuth2User) {
        if(defaultOAuth2User == null)
            return null;
        else
            return new GitHubUser(
                    defaultOAuth2User.getAttributes().get("login").toString(),
                    defaultOAuth2User.getAttributes().get("id").toString(),
                    defaultOAuth2User.getAttributes().get("avatar_url").toString(),
                    defaultOAuth2User.getAttributes().get("url").toString(),
                    defaultOAuth2User.getAttributes().get("name").toString(),
                    defaultOAuth2User.getAttributes().get("location").toString()
            );
    }
}


