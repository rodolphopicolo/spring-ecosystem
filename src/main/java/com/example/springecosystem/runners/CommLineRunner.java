package com.example.springecosystem.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

public class CommLineRunner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(args).forEach(arg -> logger.info("Command Line Argument: {}", arg));
    }
}
