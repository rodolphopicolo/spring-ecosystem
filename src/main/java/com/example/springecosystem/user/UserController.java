package com.example.springecosystem.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {
    @GetMapping("current")
    public String currentUser(){
        return "rodolpho";
    }

    @GetMapping("listUsers")
    public List<String> listUsers(){
        String[] users = new String[]{"rodolpho"};
        return Arrays.asList(users);
    }
}
