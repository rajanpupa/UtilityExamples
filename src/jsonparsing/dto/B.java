package dto;

public class B {
	public String keyC;

	public void setKeyC(String keyc2) {
		this.keyC = keyc2;
	}
	
	public String getKeyC() {
		return keyC;
	}
	
	@Override
	public String toString() {
		
		return "{ keyC : " + keyC + " }";
	}
}
