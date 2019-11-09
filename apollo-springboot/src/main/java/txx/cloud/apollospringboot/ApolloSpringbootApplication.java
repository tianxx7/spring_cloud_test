package txx.cloud.apollospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ApolloSpringbootApplication {

    public static void main(String[] args) {
        System.setProperty("env", "DEV");
        SpringApplication.run(ApolloSpringbootApplication.class, args);
    }

}
