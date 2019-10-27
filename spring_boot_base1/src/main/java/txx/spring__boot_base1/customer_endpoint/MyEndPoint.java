package txx.spring__boot_base1.customer_endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Endpoint(id = "txx")//url
public class MyEndPoint {
    @ReadOperation
    public List<Map<String, Object>> health() {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("name","txx");
        map.put("music", "年少有为");
        result.add(map);
        return result;
    }
}
