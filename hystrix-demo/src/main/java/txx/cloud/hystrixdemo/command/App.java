package txx.cloud.hystrixdemo.command;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //同步调用
        String result = new MyHystrixCommand("txx123").execute();
        //异步调用
        Future<String> result2 = new MyHystrixCommand("txx456").queue();
        System.out.println(result);
        System.out.println(result2.get());
    }
}
