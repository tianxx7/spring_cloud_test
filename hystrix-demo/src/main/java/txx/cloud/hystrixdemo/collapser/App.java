package txx.cloud.hystrixdemo.collapser;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        Future<String> future = new MyHystrixCommand("txx-coll").queue();
        Future<String> future1 = new MyHystrixCommand("txx-coll2").queue();
        System.out.println(future.get() + "=" + future1.get());
        context.shutdown();
        /*
        真正执行请求.....
        返回结果:txx-coll=返回结果:txx-coll2
        * */

        /*String result1 = new MyHystrixCommand("txx-coll").execute();
        String result2 = new MyHystrixCommand("txx-coll").execute();
        System.out.println(result1 + " = " + result2);*/

        /*
        真正执行请求.....
        真正执行请求.....
        返回结果:txx-coll = 返回结果:txx-coll
        * */
    }
}
