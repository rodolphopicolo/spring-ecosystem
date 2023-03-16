package com.example.springecosystem.availability;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StateListener {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @EventListener
    public void onStateChange(AvailabilityChangeEvent event){
        AvailabilityState state = (event.getState());
        if (state.equals(LivenessState.CORRECT)) {
            logger.info("Liveness Correct");
        } else if (state.equals(LivenessState.BROKEN)) {
            logger.info("Liveness Broken");
        } else if (state.equals(ReadinessState.ACCEPTING_TRAFFIC)){
            logger.info("Readness Accepting Traffic");
        } else if (state.equals(ReadinessState.REFUSING_TRAFFIC)){
            logger.info("Readness Refusing Traffic");
        }
    }
}
