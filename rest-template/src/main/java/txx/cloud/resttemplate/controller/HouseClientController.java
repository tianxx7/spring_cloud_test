package txx.cloud.resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import txx.cloud.resttemplate.dto.HouseInfo;

@RestController
public class HouseClientController {
    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/call/data")
    public HouseInfo getData(@RequestParam("name") String name){
        //HouseInfo forObject = restTemplate.getForObject("http://localhost:8081/house/data?name=" + name, HouseInfo.class);
        HouseInfo forObject = restTemplate.getForObject("http://ribbon-eureka-demo/house/data?name=" + name, HouseInfo.class);
        return forObject;
    }

    @GetMapping("/call/data/{name}")
    public String getData2(@PathVariable("name") String name){
        //String forObject = restTemplate.getForObject("http://localhost:8081/house/data/{name}", String.class, name);
        String forObject = restTemplate.getForObject("http://ribbon-eureka-demo/house/data/{name}", String.class, name);
        return forObject;
    }

    @GetMapping("/call/save")
    public Long add(){
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setCity("上海");
        houseInfo.setRegion("浦东");
        houseInfo.setName("xxxx");
        //Long id = restTemplate.postForObject("http://localhost:8081/house/save", houseInfo, Long.class);
        Long id = restTemplate.postForObject("http://ribbon-eureka-demo/house/save", houseInfo, Long.class);
        return id;
    }
}
