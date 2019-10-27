package txx.cloud.hystrixdemo.back;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class MyHystrixCommand extends HystrixCommand<String> {
    private final String name;

    public MyHystrixCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("MyGroup"));
        this.name = name;
    }
    @Override
    protected String run() throws Exception {
        try {
            Thread.sleep(1000*10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return this.name + ":" + Thread.currentThread().getName();
    }

    @Override
    protected String getFallback() {
        return "失败了";
    }
}
