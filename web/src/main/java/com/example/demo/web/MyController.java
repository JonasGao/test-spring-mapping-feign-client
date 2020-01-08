package com.example.demo.web;

import com.example.demo.api.MyApi;
import com.example.demo.api.SomeBody;
import com.google.common.collect.Lists;
import feign.FeignException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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

    @GetMapping("/join-hello")
    public String join() {
        return "Return: " + myApi.getJoinedString(Lists.newArrayList("Hello", "World", "Spring", "Cloud"));
    }

    @GetMapping("/join-null")
    public String joinNull() {
        return "Return: " + myApi.getJoinNull(null);
    }

    @GetMapping("/join-empty")
    public String joinEmpty1() {
        // required = false
        return "Return: " + myApi.getJoinNull(new ArrayList<>());
    }

    @GetMapping("/join-empty-fail")
    public String joinEmpty2() {
        // required = true
        return "Return: " + myApi.getJoinedString(new ArrayList<>());
    }

    @GetMapping("/test-date")
    public String testDate() {
        return "Return: " + myApi.getSomeDate();
    }

    @GetMapping("/test-rest")
    public String testRest() {
        SomeBody body = new SomeBody();
        body.setDescription("Nice Job!");
        return "Return: " + myApi.restFulGetSomeString("JoJo", body);
    }

    @GetMapping("/test-fail")
    public String testFail() {
        try {
            myApi.testFail();
            return "What ?! Succeed???? No way!!!";
        } catch (FeignException e) {
            return "Return: " + e.toString();
        }
    }

    @GetMapping("/test-pathvar")
    public String testPathVar() {
        return myApi.testPathVar("World?");
    }
}
