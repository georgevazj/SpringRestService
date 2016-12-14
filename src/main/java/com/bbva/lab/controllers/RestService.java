package com.bbva.lab.controllers;

import com.bbva.lab.models.HashModel;
import com.bbva.lab.models.Quote;
import org.apache.commons.codec.binary.Hex;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jorge on 01/12/2016.
 */

@RestController
public class RestService {

    @RequestMapping("/quote")
    public Quote quote(){
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return quote;
    }

    @RequestMapping("/hash")
    public HashModel hash(@RequestParam(value="nonce", defaultValue = "0000") String nonce) {
        MessageDigest messageDigest = null;
        String hashString = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(nonce.getBytes());
            byte[] messageBytes = messageDigest.digest();

            hashString = String.valueOf(Hex.encodeHex(messageBytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        HashModel hash = new HashModel();
        hash.setHash(hashString);
        return hash;
    }


}
