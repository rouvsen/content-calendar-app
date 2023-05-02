package com.rouvsen.controller;

import com.rouvsen.config.ContentCalendarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final ContentCalendarProperties properties;

    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentCalendarProperties home() {
        return properties;
    }

//    @Value(value = "${cc.welcomeMessage: Default Welcome Message}")
//    private String welcomeMessage;
//
//    @Value(value = "${cc.about: Default About Message}")
//    private String about;
//
//    @GetMapping("/")
//    public Map<String, String> home() {
//        return Map.of(
//                "welcomeMessage", welcomeMessage,
//                "about", about
//        );
//    }
}
