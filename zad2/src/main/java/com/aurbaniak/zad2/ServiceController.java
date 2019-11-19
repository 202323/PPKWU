package com.aurbaniak.zad2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//https://spring.io/guides/gs/rest-service/

@RestController
public class ServiceController {

    @RequestMapping("/service")
    public Service service(@RequestParam(value="text") String text) {
        Service service = new Service(text);
        service.countLowerCaseLetters();
        service.countUpperCaseLetter();
        service.countNumbers();
        service.countSpecialSigns();
        service.countAll();
        return service;

    }
}
