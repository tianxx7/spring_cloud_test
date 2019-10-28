package txx.cloud.zuuldemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalController {
    @GetMapping("/local/{id}")
    public String local(@PathVariable("id")String id){
        return id;
    }
}
