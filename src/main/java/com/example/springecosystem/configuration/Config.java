package com.example.springecosystem.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Value("${name}")
    private String appName;

    @Value("${app.profile}")
    private String appProfile;


    @EventListener
    public void onStateChange(AvailabilityChangeEvent event){
        AvailabilityState state = (event.getState());
        if (state.equals(ReadinessState.ACCEPTING_TRAFFIC)){
            System.out.println("Property value: $(name): " + appName);
            System.out.println("Property value: $(app.profile): " + appProfile);
        }

    }

}
