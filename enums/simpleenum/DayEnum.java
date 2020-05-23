package simpleenum;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public enum DayEnum {
	SUNDAY("Sunday"),
	MONDAY("Monday")
	;
	
	String value;
	
	private DayEnum(String str) {
		this.value = str;
	}
	
	public String toString() {
		return this.value;
	}
	
	public static void main(String[] args) { 
		ObjectMapper objectMapper = new ObjectMapper();
		PodamFactory podamFactory = new PodamFactoryImpl();
		
		DayEnum c1 = podamFactory.manufacturePojo(DayEnum.class);
		
        System.out.println(c1); 
    }
}
