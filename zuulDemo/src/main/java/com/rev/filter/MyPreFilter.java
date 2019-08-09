package com.rev.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class MyPreFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest req = rc.getRequest();
		System.out.println("the method: "+ req.getMethod());
		System.out.println("also: "+req.getRequestURI());
		
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
