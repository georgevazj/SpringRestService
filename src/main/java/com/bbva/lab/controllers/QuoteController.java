package com.bbva.lab.controllers;

import com.bbva.lab.models.Quote;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jorge on 01/12/2016.
 */

@RestController
public class QuoteController {

    @RequestMapping("/quote")
    public Quote quote(){
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return quote;
    }

}
