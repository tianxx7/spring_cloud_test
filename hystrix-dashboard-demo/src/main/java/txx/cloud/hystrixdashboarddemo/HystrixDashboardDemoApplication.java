package txx.cloud.hystrixdashboarddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableHystrixDashboard
@SpringBootApplication
@EnableTurbine
@EnableDiscoveryClient
public class HystrixDashboardDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardDemoApplication.class, args);
    }

}
