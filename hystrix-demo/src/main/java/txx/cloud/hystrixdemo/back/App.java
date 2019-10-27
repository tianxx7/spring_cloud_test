package txx.cloud.hystrixdemo.back;

public class App {
    public static void main(String[] args) {
        String result = new MyHystrixCommand("txx-back").execute();
        System.out.println(result);
    }
}
