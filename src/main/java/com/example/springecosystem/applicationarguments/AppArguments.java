package com.example.springecosystem.applicationarguments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class AppArguments {

    public AppArguments(ApplicationArguments args){
        System.out.println("System arguments:");
        AppArguments.dumpApplicationArguments(args);
    }

    public static void dumpApplicationArguments(ApplicationArguments args){
        List<String> nonOptionArgs = args.getNonOptionArgs();
        nonOptionArgs.forEach(arg -> System.out.println("Non Option Arg: " + arg));

        String[] sourceArgs = args.getSourceArgs();
        Arrays.asList(sourceArgs).forEach(arg -> System.out.println("Source Arg: " + arg));

        Set<String> optionNames = args.getOptionNames();
        optionNames.forEach(arg -> System.out.println("Option Names: " + arg));
    }



}
