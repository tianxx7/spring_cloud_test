package txx.springbootstarterdemo.client;

import txx.springbootstarterdemo.config.UserProperties;

public class UserClient {
    private UserProperties userProperties;

    public UserClient() {
    }

    public UserClient(UserProperties userProperties) {
        this.userProperties = userProperties;
    }

    public String getName(){
        return userProperties.getName();
    }
}
