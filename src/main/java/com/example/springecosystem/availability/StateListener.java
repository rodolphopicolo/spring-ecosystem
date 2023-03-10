package com.example.springecosystem.availability;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StateListener {

    @EventListener
    public void onStateChange(AvailabilityChangeEvent event){
        AvailabilityState state = (event.getState());
        if (state.equals(LivenessState.CORRECT)) {
            System.out.println("Liveness Correct");
        } else if (state.equals(LivenessState.BROKEN)) {
            System.out.println("Liveness Broken");
        } else if (state.equals(ReadinessState.ACCEPTING_TRAFFIC)){
            System.out.println("Readness Accepting Traffic");
        } else if (state.equals(ReadinessState.REFUSING_TRAFFIC)){
            System.out.println("Readness Refusing Traffic");
        }
    }
}
