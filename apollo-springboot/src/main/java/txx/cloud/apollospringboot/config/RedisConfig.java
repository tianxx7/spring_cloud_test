package txx.cloud.apollospringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "redis.cache")
public class RedisConfig {

	private String host;
	
}
