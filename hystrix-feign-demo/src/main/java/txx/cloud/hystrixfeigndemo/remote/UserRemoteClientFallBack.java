package txx.cloud.hystrixfeigndemo.remote;

import org.springframework.stereotype.Component;

@Component
public class UserRemoteClientFallBack implements UserRemoteClient {
    @Override
    public String hello() {
        return "fail";
    }
}
