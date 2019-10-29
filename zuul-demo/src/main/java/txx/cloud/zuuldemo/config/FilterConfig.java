package txx.cloud.zuuldemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import txx.cloud.zuuldemo.filter.ErrorFilter;
import txx.cloud.zuuldemo.filter.IpFilter;

@Configuration
public class FilterConfig {

    @Bean
    public IpFilter ipFilter(){
        return new IpFilter();
    }
    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }

}
