package reflection3;

import java.lang.reflect.Method;

public class App {

	public static void main(String[] args) throws SecurityException, ClassNotFoundException {
		
		String className1 = "reflection2.DebugProxy";
		String className2 = "reflection3.ClassReflector";
		
		String className = className2;
		ClassReflector cr = new ClassReflector(className);
		
		for(Method m : cr.getmethods()){
			String methodHeader = m.toString();
			System.out.println(m.toString());
		}
	}
}
