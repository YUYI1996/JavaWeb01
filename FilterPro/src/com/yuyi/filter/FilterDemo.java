package com.yuyi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class FilterDemo implements Filter {

   
    public FilterDemo() {
        System.out.println("destroy....");
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("这是FilterDemo过滤器执行之前……");
		chain.doFilter(request, response);
		System.out.println("这是FilterDemo过滤器执行之后……");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("我是FilterDemo，我出来了 ，你打我啊");
	}

}
