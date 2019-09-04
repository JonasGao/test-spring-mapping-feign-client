package com.example.demo.web;

import com.example.demo.api.MyApi;
import com.example.demo.api.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public SomeBean getSomeDate() {
        SomeBean someBean = new SomeBean();
        someBean.setDateField(new Date());
        return someBean;
    }
}
