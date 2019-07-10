package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;

public interface MyApi {
    @GetMapping("/api")
    String hello();
}
