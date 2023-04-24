package com.example.springecosystem.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @GetMapping(value={"protected", "not/protected"})
    public String show(){
        return "Security Controller";
    }
}
