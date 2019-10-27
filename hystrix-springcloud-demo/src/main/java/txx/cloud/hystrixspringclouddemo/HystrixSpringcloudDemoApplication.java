package txx.cloud.hystrixspringclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
public class HystrixSpringcloudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixSpringcloudDemoApplication.class, args);
    }

}
