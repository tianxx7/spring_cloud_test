package txx.cloud.eurekaconsume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consume/callHello1")
    public String getUser(){
        return restTemplate.getForObject("http://localhost:8081/user/hello",String.class);
    }

    @GetMapping("/consume/callHello2")
    public String getUser2(){
        return restTemplate.getForObject(
                "http://eureka-client-user-service/user/hello",String.class);
    }

}
