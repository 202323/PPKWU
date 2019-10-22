package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//https://spring.io/guides/gs/rest-service/

@RestController
public class ServiceController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/service")
    public Service service(@RequestParam(value="text", required = true) String text) {
        return new Service(counter.incrementAndGet(), text);
    }
}
