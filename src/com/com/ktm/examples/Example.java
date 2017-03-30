package com.ktm.examples;

public class Example {

	/**
	 * just for the purpose of checking and printing the string
	 * from the DAO's
	 * @param args
	 */
	public static void main(String[] args) {
		//sqlExample();
		
		Example e = new Example();
		
		System.out.println(e.complexNumberMultiply("1+1i", "1+1i"));
	}

	private static void sqlExample() {
		String strSQL = "SELECT ParamName,ParamVal FROM USR_FIXEDPARAMS" + " "
				+ "where ParamName ='" + "CS_User'" + " " + "OR ParamName='"
				+ "CS_Password'" + " " + "OR ParamName='" + "CS_URL'";
		
		String strSQL2 = "SELECT ParamVal FROM "
				+ "USR_FIXEDPARAMS"	+ " where Upper(ParamName) = 'CS_URL'";
		System.out.println(strSQL2);
	}
	
	public String complexNumberMultiply(String a, String b) {
        String[] ap = a.split("\\+");
        String[] bp = b.split("\\+");
        
        Integer a1 = Integer.valueOf(ap[0]);
        Integer a2 = Integer.valueOf(ap[1].replace("i", ""));
        
        Integer b1 = Integer.valueOf(bp[0]);
        Integer b2 = Integer.valueOf(bp[1].replace("i", ""));
        
        return (a1 * b1 - a2 * b2) +"+"+ ((a1 * b2 + a2 * b1) + "i"); 
        
    }
}
