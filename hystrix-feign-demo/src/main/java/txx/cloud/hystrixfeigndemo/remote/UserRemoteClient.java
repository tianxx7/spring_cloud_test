package txx.cloud.hystrixfeigndemo.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(value = "eureka-client-user-service",fallback = UserRemoteClientFallBack.class)
@FeignClient(value="eureka-client-user-service",
        fallbackFactory=UserRemoteClientFallbackFactory.class)
public interface UserRemoteClient {

    @GetMapping("/user/hello")
    String hello();
}
