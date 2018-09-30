/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in28minutes.springboot.SpringBootBase.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class WelcomeController {
    
//    @Autowired
//    UserRepository repository;
    
    @GetMapping("/")
    public String showWelcomePage(ModelMap model){
        model.put("username", getLoggedInUser());
        return "welcome";
    }
    
    private String getLoggedInUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication();
        if(principal instanceof UserDetails){
            return ((UserDetails)principal).getUsername();
        }
        return principal.toString();
    }
//    @PostMapping("/login")
//    public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password){
//        
//        boolean isValidUser = service.validateUser(username, password);
//
//        if (!isValidUser) {
//            System.out.println("****** "+username+"     "+password);
//            model.put("errorMessage", "Invalid Username/Password");
//            return "login";
//        }
//
//        model.put("username", username);
//        model.put("password", password);
//
//        return "redirect:/list-todos";
//    }
}
