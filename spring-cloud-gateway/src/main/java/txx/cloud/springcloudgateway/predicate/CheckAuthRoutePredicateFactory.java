package txx.cloud.springcloudgateway.predicate;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.function.Predicate;

@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {

    @Autowired
    private ApplicationContext context;

    public CheckAuthRoutePredicateFactory(){
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        /*String[] names = context.getBeanDefinitionNames();
        Arrays.asList(names).forEach(s -> {
            System.out.println(s);
        });*/
        return serverWebExchange -> {
            System.out.println("进入自定义断言工厂");
            if (config.getName().equals("txx")) {
                return true;
            }
            return false;
        };
    }

    public static class Config{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
