package com.example.springecosystem.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Config {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${name}")
    private String appName;

    @Value("${app.profile}")
    private String appProfile;


    @EventListener
    public void onStateChange(AvailabilityChangeEvent event){
        AvailabilityState state = (event.getState());
        if (state.equals(ReadinessState.ACCEPTING_TRAFFIC)){

            logger.info("Property value: $(name): {}", appName);
            logger.info("Property value: $(profile): {}", appProfile);
        }

    }

}
