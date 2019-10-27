package txx.cloud.feigndemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import txx.cloud.feigndemo.remote.UserRemoteClient;

@RestController
public class DemoController {
    @Autowired
    public UserRemoteClient userRemoteClient;

    @GetMapping("/callHello")
    public String callHello() {
        String result = userRemoteClient.hello();
        System.out.println("调用结果:" + result);
        return result;
    }
}
