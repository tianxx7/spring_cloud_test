package txx.spring__boot_base1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import txx.springbootstarterdemo.config.EnableUserClient;

@SpringBootApplication
@EnableUserClient
public class SpringBootBase1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBase1Application.class, args);
    }

}
