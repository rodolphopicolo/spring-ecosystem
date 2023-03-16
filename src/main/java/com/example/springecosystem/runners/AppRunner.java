package com.example.springecosystem.runners;

import com.example.springecosystem.applicationarguments.AppArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info(("Application Runner Arguments"));
        AppArguments.dumpApplicationArguments(args);
    }
}
