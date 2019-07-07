package com.example.demo.feign;

import com.example.demo.api.MyApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient
public interface MyClient extends MyApi {
}
