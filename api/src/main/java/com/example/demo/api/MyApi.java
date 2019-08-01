package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MyApi {
    @GetMapping("/api")
    String hello();

    @GetMapping("/api/join")
    String getJoinedString(@RequestParam("strings") List<String> strings);
}
