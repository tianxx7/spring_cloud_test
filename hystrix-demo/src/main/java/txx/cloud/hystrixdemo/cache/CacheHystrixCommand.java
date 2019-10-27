package txx.cloud.hystrixdemo.cache;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CacheHystrixCommand extends HystrixCommand<String> {
    private final String name;

    public CacheHystrixCommand(String name){
        super(HystrixCommandGroupKey.Factory.asKey("MyGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        System.out.println("get data");
        return this.name + ":" + Thread.currentThread().getName();
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(this.name);
    }
}
