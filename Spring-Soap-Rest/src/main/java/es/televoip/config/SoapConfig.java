package es.televoip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import es.televoip.client.SoapClient;

@Configuration
public class SoapConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("es.televoip.wsdl");

		return marshaller;
	}

	@Bean
	public SoapClient getSoapClient(Jaxb2Marshaller marshaller) {
		SoapClient soapClient = new SoapClient();
		soapClient.setDefaultUri("http://www.dneonline.com/calculator.asmx");
		soapClient.setMarshaller(marshaller);
		soapClient.setUnmarshaller(marshaller);

		return soapClient;
	}

}
