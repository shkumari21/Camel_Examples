package com.javainuse.route;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

import com.javainuse.model.Employee;
import com.javainuse.processor.MyProcessor;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		// XML Data Format
		JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(Employee.class);
		xmlDataFormat.setContext(con);

		// JSON Data Format
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);

		from("file:inputFolder").doTry().unmarshal(xmlDataFormat).process(new MyProcessor()).marshal(jsonDataFormat).

				to("jms:queue:javainuse").doCatch(Exception.class).process(new Processor() {

					public void process(Exchange exchange) throws Exception {
						Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
						System.out.println(cause);
					}
				});
	}

}
