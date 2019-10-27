package txx.cloud.resttemplate.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRule implements IRule {
    private ILoadBalancer lb;

    @Override
    public Server choose(Object o) {
        List<Server> allServers = lb.getAllServers();
        for (Server server : allServers) {
            System.out.println(server.getHost());
        }
        System.out.println("123");
        return allServers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
            this.lb = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
