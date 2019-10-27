package txx.cloud.hystrixdemo.cache;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import txx.cloud.hystrixdemo.back.MyHystrixCommand;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //直接调会报错
        //String result = new CacheHystrixCommand("txx-cache").execute();
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String result = new CacheHystrixCommand("txx-cache").execute();
        System.out.println(result);
        Future<String> queue = new CacheHystrixCommand("txx-cache").queue();
        System.out.println(queue.get());
        context.shutdown();

        //清除缓存
        HystrixRequestContext context2 = HystrixRequestContext.initializeContext();
        String result2 = new ClearCacheHystrixCommand("txx-cache").execute();
        System.out.println(result2);
        ClearCacheHystrixCommand.flushCache("txx-cache");
        Future<String> queue2 = new ClearCacheHystrixCommand("txx-cache").queue();
        System.out.println(queue2.get());
        context.shutdown();
    }
}
