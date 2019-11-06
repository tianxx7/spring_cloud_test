package txx.cloud.eurekaprovider.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import txx.cloud.eurekaprovider.bean.AddUserParam;
import txx.cloud.eurekaprovider.bean.UserDto;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户接口")
@RestController
public class UserController {
    @Autowired
    Environment environment;


    @GetMapping("/user/hello")
    public String hello(HttpServletRequest req){
        return "hi txx eureka feign";
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
