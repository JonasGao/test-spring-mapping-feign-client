package com.example.demo.web;

import com.example.demo.api.MyApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final MyApi myApi;

    public MyController(MyApi myApi) {
        this.myApi = myApi;
    }

    @GetMapping("/hello")
    public String index() {
        return "Hello, Controller";
    }

    @GetMapping("/api")
    public String api() {
        return "Return: " + myApi.hello();
    }
}
