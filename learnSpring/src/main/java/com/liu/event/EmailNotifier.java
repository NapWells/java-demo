package com.liu.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EmailNotifier implements ApplicationListener<ApplicationEvent>{

	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof EmailEvent){
			EmailEvent emailEvent = (EmailEvent) event;
			System.out.println("需要发送邮件的接受地址   " + emailEvent.getAddress());
			System.out.println("需要发送邮件的正文  " + emailEvent.getText());
		}else{
			System.out.println("其他事件：" + event.getClass().getName());
		}
	}

	

}
