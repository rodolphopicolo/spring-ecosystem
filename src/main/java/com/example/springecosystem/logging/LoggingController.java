package com.example.springecosystem.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    Logger logger2 = LoggerFactory.getLogger(this.getClass().getName() + "-2");

    @GetMapping("/implementation")
    public String loggingImplementation(){
        logger.info("INFO. Number one {}, number two {}, there is a missing part that will not be showed because missing braces...", 1, 2, "This will not be showed.");
        logger.debug("DEBUG. Number one {}, number two {}, there is a missing part that will not be showed because missing braces...", 1, 2, "This will not be showed.");
        logger2.warn("WARN - logger2. Number one {}, number two {}, there is a missing part that will not be showed because missing braces...", 1, 2, "This will not be showed.");
        return logger.getClass().getName();
    }
}
