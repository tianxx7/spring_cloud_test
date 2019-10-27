package txx.cloud.resttemplate.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name = "rest-template",configuration = BeanConfiguration.class)
public class RibbonClientConfig {
}
