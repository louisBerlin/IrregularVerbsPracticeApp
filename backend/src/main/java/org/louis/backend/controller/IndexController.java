package org.louis.backend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {


    // redirect  http://localhost:8080/login?error to index.html



    @GetMapping("/api/hello")
    public String hello( ) {

        return "redirect:/";
    }



    @GetMapping("/login?error")
    public String redirect( ) {
        System.out.println("log 1");


        return "redirect:/";
    }

    @GetMapping("/login")
    public String redirect2( @RequestParam String error) {
        System.out.println("log 2");
        return "redirect:/";
    }
}
