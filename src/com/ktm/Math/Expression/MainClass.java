package com.ktm.Math.Expression;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainClass {
    public static void main(String[] args) throws Exception {
	ScriptEngineManager mgr = new ScriptEngineManager();
	ScriptEngine engine = mgr.getEngineByName("JavaScript");
	String [] salaries= {"33048.40","34188.00","34188.00","35500.00","35500.00"};
	String foo = "";//"4+2*(22-(22/11*(2)))";
	System.out.println("Hello world");
	
	for(String abc : salaries) {
	    foo+="+" + abc;
	}
	
	System.out.println(foo + " = " + engine.eval(foo));
    }
    
    public static void beanShellIntepreter() {
//	Interpreter interpreter = new Interpreter();
//	interpreter.eval("result = (7+21*6)/(32-27)");
//	System.out.println(interpreter.get("result"));
   }
}
