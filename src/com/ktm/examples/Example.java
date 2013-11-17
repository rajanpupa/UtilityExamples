package com.ktm.examples;

public class Example {

	/**
	 * just for the purpose of checking and printing the string
	 * from the DAO's
	 * @param args
	 */
	public static void main(String[] args) {
		String strSQL = "SELECT ParamName,ParamVal FROM USR_FIXEDPARAMS" + " "
				+ "where ParamName ='" + "CS_User'" + " " + "OR ParamName='"
				+ "CS_Password'" + " " + "OR ParamName='" + "CS_URL'";
		
		String strSQL2 = "SELECT ParamVal FROM "
				+ "USR_FIXEDPARAMS"	+ " where Upper(ParamName) = 'CS_URL'";
		System.out.println(strSQL2);
	}
}
