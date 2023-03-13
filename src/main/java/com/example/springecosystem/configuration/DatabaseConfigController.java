package com.example.springecosystem.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/database")
public class DatabaseConfigController {
    @Autowired
    DatabaseConfig databaseConfig;

    @GetMapping("/config")
    public List<String> databaseConfig(){
        List<String> config = new ArrayList();
        config.add("username: " + databaseConfig.getUsername());
        config.add("password: " + databaseConfig.getPassword());
        config.add("host: " + databaseConfig.getHost());
        config.add("port: " + databaseConfig.getPort());

        return config;
    }
}
