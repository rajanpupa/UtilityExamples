package test;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class Main {
	static ObjectMapper objectMapper = new ObjectMapper();
	static PodamFactory podamFactory = new PodamFactoryImpl();
	
	public static void main(String[] args) throws IOException {
		SampleDto c1 = podamFactory.manufacturePojo(SampleDto.class);
		System.out.println(c1);
		
		String json = objectMapper.writeValueAsString(c1);
		System.out.println(json);
		
		SampleDto deserialized = objectMapper.readValue(json, SampleDto.class);
        System.out.println(deserialized); 
	}

}
