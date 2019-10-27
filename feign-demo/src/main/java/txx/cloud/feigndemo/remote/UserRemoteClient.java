package txx.cloud.feigndemo.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import txx.cloud.feigndemo.config.FeignConfiguration;

//服务提供者
@FeignClient(value = "eureka-client-user-service",configuration = FeignConfiguration.class)
public interface UserRemoteClient {

    @GetMapping("/user/hello")
    String hello();
}
