package caching;

public class Test2 {

	public static void main(String[] args) {
		
		String sridhar = "Sridhar";
		String eSridhar = EncryptionUtil.encrypt(sridhar);
		
		String sridhar2 = "Sridhar";
		EncryptionUtil.encrypt(sridhar2);
		
		String Amin = "Amin";
		String eAmin = EncryptionUtil.encrypt(Amin);
		
		String dAmin = EncryptionUtil.decrypt(eAmin);
		
		String ilAn = "ilAn";
		String dilAn = EncryptionUtil.decrypt(ilAn);
	}
}
