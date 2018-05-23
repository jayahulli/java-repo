package com.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UserFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("In UserFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		HeaderRequestWrapper requestWrapper = new HeaderRequestWrapper(req);
		requestWrapper.addHeader("user", "Test1234");
		chain.doFilter(requestWrapper, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	public class HeaderRequestWrapper extends HttpServletRequestWrapper{

		public HeaderRequestWrapper(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
		}
		
		private Map< String , String > headerMap = new HashMap<String , String>();
		
		public void addHeader(String name , String value){
			headerMap.put(name, value);
		}
		
		@Override
		public String getHeader(String name){
			String headerValue = super.getHeader(name);
			if(headerMap.containsKey(name)){
				headerValue = headerMap.get(name);
			}
			return headerValue;
		}
		
	}

}
