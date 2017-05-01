package index;

public class Bit {

	int value;
	
	public Bit(int value){
		this.value = value;
	}
	
	public static void main(String[] args) {
		Bit b = new Bit(-100);
		System.out.println(b);
		System.out.println("setting 0th bit: " + b.setBit(0));
		System.out.println("unsetting 2nd bit: " + b.unsetBit(2));
		System.out.println("toggle 0th bit: " + b.toggleBit(0));
		System.out.println("toggle 0th bit: " + b.toggleBit(0));
	}
	
	public Bit setBit(int n){
		value |= (1<<n);
		return this;
	}
	
	public Bit unsetBit(int n){
		value &= ~(1<<n);
		return this;
	}
	
	public Bit toggleBit(int n){
		value ^= (1<<n);
		return this;
	}
	
	@Override
	public String toString() {
		return Integer.toBinaryString(value);
	}
}
