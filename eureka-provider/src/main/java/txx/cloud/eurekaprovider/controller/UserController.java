package txx.cloud.eurekaprovider.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import txx.cloud.eurekaprovider.bean.AddUserParam;
import txx.cloud.eurekaprovider.bean.UserDto;


@Api(tags = "用户接口")
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    Environment environment;


    @GetMapping("/user/hello")
    public String hello(){
        //加了这个才会有调用信息打印出来,重要
        logger.info("我是/user/hello");
        return "hello2";
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户id", dataType = "string",
            paramType = "query", required = true, defaultValue = "1")})
    @ApiResponse(code = 200, message = "OK", response = UserDto.class)
    @GetMapping("/getUser")
    public UserDto getUser(@RequestParam("id") String id) {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName("吴涛");
        return userDto;
    }

    @ApiOperation(value = "添加用户",notes = "详细描述")
    @ApiResponses({@ApiResponse(code = 200,message = "OK",response = UserDto.class)})
    @PostMapping("/user")
    public UserDto addUser(@ApiParam(value = "新增用户参数11",required = true) @RequestBody AddUserParam param){
        System.out.println(param.getName());
        return new UserDto();
    }
}
