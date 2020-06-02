package com.aaa.zk.filter;/*
 *@Company：
 *@Author：何康
 *@Date：2020/6/2 18:43
 *@Description:
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import static com.aaa.zk.status.TokenStatus.*;

public class OrderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return TYPE_PRE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return false;
    }

    public Object run() throws ZuulException {
        return null;
    }
}
