package test;

public interface AInterface {

	public Double PI = 3.1415;//implicitely static final
	//private Integer count = 1;// not allowed modifier
	
	void print(String str);
	
	default void defaultPrint(String str){
		System.out.println("Hello World: " + str);
	}
	
	default public void main(String args){
		System.out.println("Inside the main method:");
	}
}
