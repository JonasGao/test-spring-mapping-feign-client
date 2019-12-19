package com.example.demo.web;

import com.example.demo.api.MyApi;
import com.example.demo.api.SomeBody;
import com.google.common.collect.Lists;
import feign.FeignException;
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

    @GetMapping("/join-hello")
    public String join() {
        return "Return: " + myApi.getJoinedString(Lists.newArrayList("Hello", "World", "Spring", "Cloud"));
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
