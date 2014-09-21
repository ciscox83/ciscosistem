package it.ciscosistem.examples.JmsSpringCamel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JmsWithCamel {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("camel-context.xml");
		CamelContext camel = context.getBean(CamelContext.class);
		
		ProducerTemplate producer = camel.createProducerTemplate();
		producer.sendBody("activemq:queue:my.queue", "Hello Spring's Fellow!");

		try {
			camel.stop();
		} catch (Exception e) {};
	}
	
}
