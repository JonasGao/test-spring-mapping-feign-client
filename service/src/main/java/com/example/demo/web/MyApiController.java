package com.example.demo.web;

import com.example.demo.api.MyApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyApiController implements MyApi {
    @Override
    public String hello() {
        return "Hello, Api";
    }

    @Override
    public String getJoinedString(@RequestParam("strings") List<String> strings) {
        return String.join("|", strings);
    }
}
