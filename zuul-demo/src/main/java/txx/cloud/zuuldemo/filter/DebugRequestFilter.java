package txx.cloud.zuuldemo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.prism.shader.DrawEllipse_LinearGradient_PAD_AlphaTest_Loader;
import org.apache.commons.io.IOUtils;
import org.springframework.cloud.netflix.ribbon.RibbonHttpResponse;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class DebugRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        System.out.println("Request:" + request.getScheme() + " " + request.getRemoteAddr() + ":" + request.getRemotePort());
        StringBuilder params = new StringBuilder("?");
        //获取URL参数
        System.out.println("URL参数");
        Enumeration<String> names = request.getParameterNames();
        if (request.getMethod().equals("GET")) {
            while (names.hasMoreElements()){
                String name = names.nextElement();
                params.append(name);
                params.append("=");
                params.append(request.getParameter(name));
                params.append("&");
            }
        }
        if (params.length() > 0){
            params.delete(params.length()-1,params.length());
        }
        System.out.println("Request :> " + request.getMethod() + " " + request.getRequestURI() +
                params + " " + request.getProtocol());
        System.out.println("请求头:");
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String name = (String) headers.nextElement();
            String value = request.getHeader(name);
            System.out.println("Request:: > " + name + ":" + value);
        }

        System.out.println("请求体:");
        //获取请求体参数
        if (!context.isChunkedRequestBody()) {
            ServletInputStream inp = null;
            try {
                inp = context.getRequest().getInputStream();
                String body = null;
                if (inp != null) {
                    body = IOUtils.toString(inp);
                    System.out.println("REQUEST:: > " + body);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("响应体:");
        //获取响应体 1
        /*try{
            Object zuulResponse = context.get("zuulResponse");
            if (zuulResponse != null) {
                RibbonHttpResponse ribbonHttpResponse = (RibbonHttpResponse) zuulResponse;
                String body = IOUtils.toString(ribbonHttpResponse.getBody());

                System.out.println("Response:> "  + body);
                ribbonHttpResponse.close();
                context.setResponseBody(body);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        InputStream stream = context.getResponseDataStream();
        try {
            if (stream != null) {
                String s = IOUtils.toString(stream, "UTF-8");
                System.out.println("Response:> "  + s );
                context.getResponse().setHeader("Content-Type","application/json;charset=UTF-8");
                RequestContext.getCurrentContext().setResponseBody(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
