package com.kashif.Greet_API.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "welcome-sit")
public interface WelcomeApiClient {

    @GetMapping("/welcome")
    public String invokeWelcomeApi();
}
