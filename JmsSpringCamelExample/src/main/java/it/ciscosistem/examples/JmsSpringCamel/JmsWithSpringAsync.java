package it.ciscosistem.examples.JmsSpringCamel;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsWithSpringAsync {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
            	return session.createTextMessage("Hello Spring's Fellow!");
            }
        });	
	}
}
