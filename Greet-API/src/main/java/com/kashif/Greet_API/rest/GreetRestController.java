package com.kashif.Greet_API.rest;

import com.kashif.Greet_API.clients.WelcomeApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetRestController {

    @Value("${msg}")
    private String greetApiMsg;

    @Autowired
    private WelcomeApiClient welcomeApiClient;

    @GetMapping("/greet")
    public String getGreetMsg() {

//        String url = "http://localhost:8081/welcome";
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
//        String welcomeApiMsg = forEntity.getBody();

        String welcomeApiMsg = welcomeApiClient.invokeWelcomeApi();
        return welcomeApiMsg+" , "+greetApiMsg;
    }
}
