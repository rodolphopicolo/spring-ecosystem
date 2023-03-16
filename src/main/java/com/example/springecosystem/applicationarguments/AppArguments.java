package com.example.springecosystem.applicationarguments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class AppArguments {

    static Logger logger = LoggerFactory.getLogger(AppArguments.class);

    public AppArguments(ApplicationArguments args){
        AppArguments.logger.info("System arguments");
        AppArguments.dumpApplicationArguments(args);
    }

    public static void dumpApplicationArguments(ApplicationArguments args){
        List<String> nonOptionArgs = args.getNonOptionArgs();
        nonOptionArgs.forEach(arg -> AppArguments.logger.info("Non Option Arg: {}", arg));

        String[] sourceArgs = args.getSourceArgs();
        Arrays.asList(sourceArgs).forEach(arg -> AppArguments.logger.info("Source Arg: {}", arg));

        Set<String> optionNames = args.getOptionNames();
        optionNames.forEach(arg -> AppArguments.logger.info("Option Names: {}", arg));
    }
}
