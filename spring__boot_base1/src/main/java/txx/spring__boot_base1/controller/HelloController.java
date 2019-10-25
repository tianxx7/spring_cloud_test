package txx.spring__boot_base1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import txx.spring__boot_base1.config.MyConfig;

@RestController
public class HelloController {
    @Autowired
    private Environment environment;
    @Value("${server.port}")
    String port;

    @Autowired
    MyConfig config;

    //从环境变量中读取
    @GetMapping("/hello")
    public String Hello(){
        String port = environment.getProperty("server.port");
        return port;
    }

    @GetMapping("/byvalue")
    public String byValue(){
        return port;
    }

    @GetMapping("/name")
    public String getName(){
        return config.getName()+"123";
    }


}
