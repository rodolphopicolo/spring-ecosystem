package com.example.springecosystem.eventlisteners;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventsListener {
    @EventListener
    public void onStateChange(ApplicationEvent event){
        System.out.println("Event listened: " + event.toString());
    }
}
