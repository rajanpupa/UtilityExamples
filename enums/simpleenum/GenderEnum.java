package simpleenum;

// Simplest way to use an Enum
public enum GenderEnum {
	MALE,
	FEMALE;
	
	public static void main(String[] args) 
    { 
		GenderEnum c1 = GenderEnum.valueOf("MALE"); 
        System.out.println(c1); 
    } 
}


