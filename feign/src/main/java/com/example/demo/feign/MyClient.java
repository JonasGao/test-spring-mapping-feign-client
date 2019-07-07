package com.example.demo.feign;

import com.example.demo.api.MyApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("demo-service")
public interface MyClient extends MyApi {
}
