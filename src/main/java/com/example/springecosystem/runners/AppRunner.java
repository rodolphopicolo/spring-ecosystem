package com.example.springecosystem.runners;

import com.example.springecosystem.applicationarguments.AppArguments;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(("Application Runner Arguments:"));
        AppArguments.dumpApplicationArguments(args);
    }
}
