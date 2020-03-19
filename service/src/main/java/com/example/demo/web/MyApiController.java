package com.example.demo.web;

import com.example.demo.api.MyApi;
import com.example.demo.api.SomeBean;
import com.example.demo.api.SomeBody;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @Override
    public String getJoinNull(@RequestParam(value = "strings", required = false) List<String> strings){
        if (CollectionUtils.isEmpty(strings)) {
            return "Empty!";
        }
        return getJoinedString(strings);
    }

    @Override
    public SomeBean getSomeDate() {
        SomeBean someBean = new SomeBean();
        someBean.setDateField(new Date());
        return someBean;
    }

    @Override
    public String restFulGetSomeString(@PathVariable("name") String name, @RequestBody SomeBody body) {
        return String.format("Hello, %s. I get your description: \"%s\"", name, body.getDescription());
    }

    @Override
    public ResponseEntity<String> testFail() {
        return ResponseEntity.status(500).body("Oh, there is an error!");
    }

    @Override
    public String testPathVar(@PathVariable("path-var") String var) {
        return "Hello: " + var;
    }

    @Override
    public String deleteSomeThing(@RequestBody List<String> stringList) {
        return String.join("|", stringList);
    }
}
