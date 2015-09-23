
/*
 * 
 * Use the keyword transient to avoid a field from serialize
 */

public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 2L;
	
	public String name;
	public String address;
	public transient int SSN;
	public int number;

	public void mailCheck2() {
		System.out.println("*****Mailing a check to " + name + " " + address);
	}
}
