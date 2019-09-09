package com.imooc.coupon.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>校验请求中传递的 Token</h1>
 * Created by zwyu.
 */
@Slf4j
@Component
public class TokenFilter extends AbstractPreZuulFilter {

    @Override
    protected Object cRun() {

        HttpServletRequest request = context.getRequest();
        log.info(String.format("%S request to %S",
                request.getMethod(), request.getRequestURL().toString()));

        Object token = request.getParameter("token");
        if (null == token){
            log.error("error: token is empty");
            return fail(401, "error: token is empty");
        }

        return success();
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}
