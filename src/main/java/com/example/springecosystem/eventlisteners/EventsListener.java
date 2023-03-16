package com.example.springecosystem.eventlisteners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventsListener {

    Logger logger = LoggerFactory.getLogger(EventListener.class);
    @EventListener
    public void onStateChange(ApplicationEvent event){
        logger.info("Event listened: {}", event.toString());
    }
}
