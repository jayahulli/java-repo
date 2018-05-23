package com.web.cxf.in.handler;

import javax.servlet.http.HttpServletRequest;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;

public class CxfInPutHandler extends AbstractPhaseInterceptor<Message>{

	public CxfInPutHandler() {
		super(Phase.PRE_STREAM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleMessage(final Message message) throws Fault {
		// TODO Auto-generated method stub
		System.out.println("In In handleMessage(Message arg0)");
		String user = "";
		String pid = "";
		String pathInfo = "";
		if(message.getExchange().getInMessage() != null){
			if(message.getExchange().getInMessage().get(AbstractHTTPDestination.HTTP_REQUEST) != null){
				HttpServletRequest request = (HttpServletRequest) message.getExchange().getInMessage().get(AbstractHTTPDestination.HTTP_REQUEST);
				user = request.getHeader("user");
				pid = request.getHeader("pid");
				pathInfo = request.getPathInfo();
			}
		}else{
			System.out.println("Failed to get HTTP request");
		}
		
	}

}
