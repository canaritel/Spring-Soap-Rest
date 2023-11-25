package es.televoip.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.televoip.client.SoapClient;
import es.televoip.wsdl.AddResponse;
import es.televoip.wsdl.DivideResponse;
import es.televoip.wsdl.MultiplyResponse;
import es.televoip.wsdl.SubtractResponse;

@RestController
public class SoapController {

	private final SoapClient soapClient;

	public SoapController(SoapClient soapClient) {
		this.soapClient = soapClient;
	}

	@PostMapping("/sumar")
	public ResponseEntity<?> add(@RequestParam int numberA, @RequestParam int numberB) {

		Map<String, Integer> response = new HashMap<>();
		AddResponse addResponse = soapClient.getAddResponse(numberA, numberB);
		response.put("Resultado", addResponse.getAddResult());

		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/restar")
	public ResponseEntity<?> subtract(@RequestParam int numberA, @RequestParam int numberB) {

		Map<String, Integer> response = new HashMap<>();
		SubtractResponse subtractResponse = soapClient.getSubtractResponse(numberA, numberB);
		response.put("Resultado", subtractResponse.getSubtractResult());

		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/multiplicar")
	public ResponseEntity<?> multiply(@RequestParam int numberA, @RequestParam int numberB) {

		Map<String, Integer> response = new HashMap<>();
		MultiplyResponse multiplyResponse = soapClient.getMultiplyResponse(numberA, numberB);
		response.put("Resultado", multiplyResponse.getMultiplyResult());

		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/dividir")
	public ResponseEntity<?> divide(@RequestParam int numberA, @RequestParam int numberB) {

		Map<String, Integer> response = new HashMap<>();
		DivideResponse divideResponse = soapClient.getDivideResponse(numberA, numberB);
		response.put("Resultado", divideResponse.getDivideResult());

		return ResponseEntity.ok().body(response);
	}

}
