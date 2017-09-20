package com.cai.mall.handler;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.cai.mall.domain.User;





@Component
public class RegistEmailHandler {
	//implements InitializingBean
	private final static Logger log = LoggerFactory.getLogger(RegistEmailHandler.class);
	
	private final static ConcurrentLinkedQueue<User> queue = new ConcurrentLinkedQueue<User>();

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SimpleMailMessage templateMessage;

	public void sendEmail() {
		
			log.info("----begin send email--------");
			User user = queue.poll();
			log.info("---- send email sleep--------");
			SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
			msg.setTo("1729368488@qq.com");
			msg.setText("尊敬的用户" + user.getUsername() + "，您的账户已经开启,请愉快的玩耍吧");
			mailSender.send(msg);
			log.info("---------邮件已经发送了 赶紧看看------------");
	}
	
	
	public void submit(User user) {
		queue.offer(user);
	}

//	@Override
//	public void afterPropertiesSet() throws Exception {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				sendEmail();
//			}
//		}).start();
//	}

}
