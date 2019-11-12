package txx.cloud.sleuthuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SleuthUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthUserApplication.class, args);
    }

}
