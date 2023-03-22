package com.example.springecosystem.exceptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("throwException")
    public void throwException() throws Exception {
        throw new Exception("throw new Exception");
    }

    @GetMapping("throwCustomException")
    public void throwCustomException() throws CustomException {
        throw new CustomException();
    }
}
