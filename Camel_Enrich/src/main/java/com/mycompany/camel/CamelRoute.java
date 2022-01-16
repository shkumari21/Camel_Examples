package com.mycompany.camel;


import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelRoute extends RouteBuilder {

		
		  private static SampleAggregator aggregationStrategy = new SampleAggregator();

			public void configure() throws Exception {

		        
			
				from("file:work/enrich/in")
		            .log(">> Before enrichment. File content is : ${body}")
		            .enrich("direct:resource", aggregationStrategy)
		         
		            .log(">> After enrichment. File content : ${body}")   .to("file:work/enrich/out");

				/*
				 * from("direct:resource") .setExchangePattern(ExchangePattern.InOut)
				 * .transform().constant("Enriching text");
				 */ 
				
				from("direct:resource")
				.process(new Processor() {
				    public void process(Exchange exchange) {
				        Message in = exchange.getIn();
				        in.setBody(in.getBody(String.class) + " Camel Enrich Example");
				    }
				});
			}
	}


