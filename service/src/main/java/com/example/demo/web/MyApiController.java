package com.example.demo.web;

import com.example.demo.api.MyApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyApiController implements MyApi {
    @Override
    public String hello() {
        return "Hello, Api";
    }
}
