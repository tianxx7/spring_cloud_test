package txx.cloud.zuuldemo.fallback;

import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import txx.cloud.zuuldemo.base.ResponseCode;
import txx.cloud.zuuldemo.base.ResponseData;
import txx.cloud.zuuldemo.filter.JsonUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class ServiceConsumerFallbackProvider implements FallbackProvider {
    private Logger log = LoggerFactory.getLogger(ServiceConsumerFallbackProvider.class);

    @Override
    public String getRoute() {
        //*代表对所有服务回退,
        // 如果只对某个服务进行回退,
        // 那么就需要返回需要回退的服务名称,这个名称一定要注册到Eureka中
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                if (cause != null) {
                    log.error("",cause.getCause());
                }
                RequestContext context = RequestContext.getCurrentContext();
                ResponseData data = ResponseData.fail("服务器内部错误", ResponseCode.SERVER_ERROR_CODE.getCode());

                return new ByteArrayInputStream(JsonUtils.toJson(data).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
                httpHeaders.setContentType(mediaType);
                return httpHeaders;
            }
        };
    }
}
