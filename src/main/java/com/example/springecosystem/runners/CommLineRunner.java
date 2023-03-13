package com.example.springecosystem.runners;

import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

public class CommLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Command Line Runner: Command Line Arguments:");
        Arrays.stream(args).forEach(arg -> System.out.println("Command Line Argument:" + arg));
    }
}
