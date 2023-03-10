package com.example.springecosystem.availability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private ApplicationContext appContext;

    private final ApplicationEventPublisher applicationEventPublisher;

    public StateController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/acceptTraffic")
    public void setReadnessStateAcceptingTraffic(){
        AvailabilityChangeEvent.publish(this.applicationEventPublisher, this, ReadinessState.ACCEPTING_TRAFFIC);
    }

    @GetMapping("/refuseTraffic")
    public void setReadnessStateRefusingTraffic(){
        AvailabilityChangeEvent.publish(this.applicationEventPublisher, this, ReadinessState.REFUSING_TRAFFIC);
    }


    @GetMapping("/correct")
    public void setLivenessCorrect(){
        AvailabilityChangeEvent.publish(this.applicationEventPublisher, this, LivenessState.CORRECT);
    }

    @GetMapping("/break")
    public void setLivenessBroken(){
        AvailabilityChangeEvent.publish(this.applicationEventPublisher, this, LivenessState.BROKEN);
    }

    @GetMapping("/shutdown")
    public String shutdown(){
        SpringApplication.exit(appContext, ()->8);
        return "Shutting down...";
    }
}
