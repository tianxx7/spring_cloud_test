package txx.cloud.hystrixdemo.collapser;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.command.BatchHystrixCommand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyHystrixCommand extends HystrixCollapser<List<String>,String,String> {
    private final String name;

    MyHystrixCommand(String name){
        this.name = name;
    }


    @Override
    public String getRequestArgument() {
        return name;
    }

    @Override
    protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String, String>> requests) {
        return new BatchCommand(requests);
    }



    @Override
    protected void mapResponseToRequests(List<String>  batchResponse, Collection<CollapsedRequest<String, String>> requests) {
        int count = 0;
        for (CollapsedRequest<String, String> request : requests) {
            request.setResponse(batchResponse.get(count++));
        }
    }

    private static final class BatchCommand extends HystrixCommand<List<String>> {

        private final Collection<CollapsedRequest<String,String>> requests;

        private BatchCommand(Collection<CollapsedRequest<String,String>> requests){
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey("GetValueForKey")));
            this.requests = requests;
        }

        @Override
        protected List<String> run() throws Exception {
            System.out.println("真正执行请求.....");
            ArrayList<String> response = new ArrayList<>();
            for (CollapsedRequest<String, String> request : requests) {
                response.add("返回结果:" + request.getArgument());
            }
            return response;
        }
    }
}
