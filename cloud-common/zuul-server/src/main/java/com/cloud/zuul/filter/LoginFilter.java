package com.cloud.zuul.filter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述 登录过滤器
 */
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 过滤器类型，前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器顺序，越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {

        return 4;
    }


    /**
     * 过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest  request = requestContext.getRequest();

        //ACL
        // 用户调用订单查询服务 先检查是否登录
        if ("/apigateway/order/order/findOrder".equalsIgnoreCase(request.getRequestURI())){
            return true;
        }
        return false;
    }

    /**
     * 业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run()   {

        //JWT
        RequestContext requestContext =  RequestContext.getCurrentContext();
        HttpServletRequest  request = requestContext.getRequest();

        //token对象
        String token = request.getHeader("token");

        if(!StringUtils.isBlank((token))){
            token  = request.getParameter("token");
        }

        //登录校验逻辑  根据公司情况自定义 JWT
        if (StringUtils.isBlank(token)) {
            System.err.println("当前用户,没有对应的权限操作...");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
