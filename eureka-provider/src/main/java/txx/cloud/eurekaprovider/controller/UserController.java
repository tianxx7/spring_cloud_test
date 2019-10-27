package txx.cloud.eurekaprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    Environment environment;
    @GetMapping("/user/hello")
    public String hello(){
        return "hi txx eureka";
    }
}