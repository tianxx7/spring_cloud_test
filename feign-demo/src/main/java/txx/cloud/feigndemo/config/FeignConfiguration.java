package txx.cloud.feigndemo.config;

import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import txx.cloud.feigndemo.auth.FeignBasicAuthRequestInterceptor;

@Configuration
public class FeignConfiguration {
    /*
    * 日志级别
    * */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /*
    * 认证
    * */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","password");
    }

    @Bean
    public FeignBasicAuthRequestInterceptor feignBasicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

    /*
    * 超时
    * 连接超时
    * 读取超时
    * */
    public Request.Options options(){
        return new Request.Options(5000,10000);
    }
}
