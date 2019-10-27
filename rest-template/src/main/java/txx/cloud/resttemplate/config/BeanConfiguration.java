package txx.cloud.resttemplate.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import txx.cloud.resttemplate.interceptor.MyLoadBalanced;
import txx.cloud.resttemplate.rule.MyRule;

@Configuration
public class BeanConfiguration {

    @Bean
    //@LoadBalanced
    @MyLoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule iRule(){
        return new MyRule();
    }
}
