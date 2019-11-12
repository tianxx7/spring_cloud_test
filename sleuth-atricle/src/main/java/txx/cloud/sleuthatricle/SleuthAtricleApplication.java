package txx.cloud.sleuthatricle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SleuthAtricleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthAtricleApplication.class, args);
    }

}
