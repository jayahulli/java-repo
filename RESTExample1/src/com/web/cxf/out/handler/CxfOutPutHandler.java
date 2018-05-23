package com.web.cxf.out.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

public class CxfOutPutHandler extends AbstractPhaseInterceptor<Message>{

	public CxfOutPutHandler() {
		super(Phase.PRE_STREAM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleMessage(final Message message) throws Fault {
		// TODO Auto-generated method stub
		System.out.println("In Out handleMessage(final Message message)");
		if(message.getExchange().getInMessage() != null){
			if(message.getExchange().getInMessage().get(AbstractHTTPDestination.HTTP_REQUEST) != null){
				HttpServletRequest request = (HttpServletRequest) message.getExchange().getInMessage().get(AbstractHTTPDestination.HTTP_REQUEST);
			}
		}else{
			System.out.println("Fail to get the HTTP request");
		}
		
	}

}
