package es.televoip;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.televoip.client.SoapClient;
import es.televoip.wsdl.AddResponse;
import org.slf4j.Logger;

@SpringBootApplication
public class SpringSoapApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringSoapApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner init(SoapClient soapClient) {
		return args -> {
			AddResponse addResponse = soapClient.getAddResponse(2, 3);

			LOGGER.info("El resultado de la suma de los numeros {} y {} es: {}", 2, 3, addResponse.getAddResult());
		};
	}
	*/

}
