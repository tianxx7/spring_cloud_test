package txx.cloud.zuuldemo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import txx.cloud.zuuldemo.base.ResponseCode;
import txx.cloud.zuuldemo.base.ResponseData;
import txx.cloud.zuuldemo.util.IpUtils;
import txx.cloud.zuuldemo.util.JsonUtils;

import java.util.Arrays;
import java.util.List;

public class IpFilter extends ZuulFilter {
    //IP黑名单列表
    private List<String> blackIpList = Arrays.asList("127.0.0.1");

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        Object isSuccess = currentContext.get("isSuccess");
        return isSuccess == null ? true :Boolean.parseBoolean(isSuccess.toString());
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        String ip = IpUtils.getIpAddr(ctx.getRequest());
//        System.out.println(2/0);
        // 在黑名单中禁用
        if (StringUtils.isNotBlank(ip) && blackIpList.contains(ip)) {
            ctx.setSendZuulResponse(false);

            ResponseData data = ResponseData.fail("非法请求", ResponseCode.NO_AUTH_CODE.getCode());
            ctx.setResponseBody(JsonUtils.toJson(data));
            ctx.set("isSuccess",false);
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }
        return null;
    }
}
