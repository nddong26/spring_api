package com.example.spring_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/read")
@CrossOrigin
public class RandomController {
    private static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static Random random = new Random();
    @GetMapping(path = "/single")
    public ResponseEntity<Object> getProperties() throws InterruptedException {
        Thread.sleep(10);

        return new ResponseEntity<>(generateString(512), HttpStatus.OK);
    }

    @GetMapping(path = "/error/{abc}")
    public ResponseEntity<Object> getProperties(@PathVariable(name = "abc") String abc) throws InterruptedException {
        Long temp = Long.parseLong(abc);

        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    public String generateString(int length) {
        StringBuilder result = new StringBuilder();
        var charactersLength = characters.length();
        for (var i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(charactersLength)));
        }
        return result.toString();
    }
}
