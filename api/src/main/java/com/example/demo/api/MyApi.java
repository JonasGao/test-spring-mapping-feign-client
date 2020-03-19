package com.example.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MyApi {
    @GetMapping("/api")
    String hello();

    @GetMapping("/api/join")
    String getJoinedString(@RequestParam("strings") List<String> strings);

    @GetMapping("/api/join-null")
    String getJoinNull(@RequestParam(value = "strings", required = false) List<String> strings);

    @GetMapping("/api/date")
    SomeBean getSomeDate();

    @PostMapping("/api/strings/{name}")
    String restFulGetSomeString(@PathVariable("name") String name, @RequestBody SomeBody body);

    @PostMapping("/api/fail")
    ResponseEntity<String> testFail();

    @GetMapping("/api/pathvar/{path-var}")
    String testPathVar(@PathVariable("path-var") String var);

    @DeleteMapping("/api/some-thing")
    String deleteSomeThing(@RequestBody List<String> stringList);
}
