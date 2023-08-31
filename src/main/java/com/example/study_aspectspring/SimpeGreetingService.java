package com.example.study_aspectspring;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class SimpeGreetingService implements GreetingService {
    @Override
    @SFR
    public String getGreeting(String name) {
        return "fdsfsdfsdf";
    }

    @Override
    public String getGreetingAnnotated(String name) {
        return "Alex";
    }

    @Override
    public String getGreeting(String result, String res) {
        return "Water is small";
    }
}