package txx.cloud.resttemplate.controller;

import org.springframework.web.bind.annotation.*;
import txx.cloud.resttemplate.dto.HouseInfo;

@RestController
public class HouseController {
    @GetMapping("/house/data")
    public HouseInfo getData(@RequestParam("name")String name){
        return new HouseInfo(1L,"上海","虹口","大渡河路");
    }

    @GetMapping("/house/data/{name}")
    public String getData2(@PathVariable("name") String name){
        return name;
    }

    @PostMapping("/house/save")
    public Long addData(@RequestBody HouseInfo houseInfo){
        System.out.println(houseInfo.getName());
        return 1001L;
    }
}
