package it.ciscosistem.examples.JmsSpringCamel;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class JmsWithoutSpring {

	public static void main(String[] args) {
		
		Connection conn = null; 
		Session session = null;
		try {
			ConnectionFactory cf = new ActiveMQConnectionFactory("vm://localhost:61616");		
			conn = cf.createConnection();
			conn.start();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = new ActiveMQQueue("my.queue");
			
			MessageProducer producer = session.createProducer(destination);
			TextMessage pMessage = session.createTextMessage();
			pMessage.setText("Hello Spring's Fellow!");
			producer.send(pMessage);
		
			MessageConsumer consumer = session.createConsumer(destination);
			Message cMessage = consumer.receive();
			TextMessage textMessage = (TextMessage) cMessage;
			System.out.println(textMessage.getText());
			
			conn.stop();
		} catch(JMSException e){}
		finally{
			try {
				if (session!=null) { session.close(); }
				if (conn!=null) { conn.close(); }
			} catch(JMSException ex){}
		}
	}
}
