package com.bbva.lab.controllers;

import com.bbva.lab.models.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jorge on 01/12/2016.
 */

@RestController
public class GreetingController {

    private static final String template = "Hola, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name ){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


}
