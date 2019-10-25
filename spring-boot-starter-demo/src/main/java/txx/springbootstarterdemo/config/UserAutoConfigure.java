package txx.springbootstarterdemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import txx.springbootstarterdemo.client.UserClient;

@Configuration
@EnableConfigurationProperties(UserProperties.class)
public class UserAutoConfigure {
    @Bean
    //@ConditionalOnProperty(prefix = "spring.user",value = "enable",havingValue = "true")
    public UserClient userClient(UserProperties properties){
        return new UserClient(properties);
    }
}
