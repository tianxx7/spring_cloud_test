package txx.cloud.eurekaconsume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private RestTemplate restTemplate;
    /*
    * 和Eureka集成使用@loadBalance的restTemplate不能使用localhost,应该使用服务名
    * */
    @GetMapping("/consume/callHello1")
    public String getUser(){
        return restTemplate.getForObject("http://localhost:8081/user/hello",String.class);
    }

    @GetMapping("/consume/callHello2")
    public String getUser2(){
        logger.info("我是/article/callHello");
        return restTemplate.getForObject(
                "http://eureka-client-user-service/user/hello",String.class);
    }

}
