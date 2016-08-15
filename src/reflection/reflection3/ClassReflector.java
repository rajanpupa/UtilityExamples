package reflection3;

import java.lang.reflect.Method;

public class ClassReflector {
	
	private String qualifiedClassName=null;
	private Class loadedClass=null;
	
	public ClassReflector(){}
	public ClassReflector(String fullClassName){
		this.qualifiedClassName = fullClassName;
	}
	
	private void loadClass() throws SecurityException, ClassNotFoundException{
		if(loadedClass == null){
			this.loadedClass = Class.forName(qualifiedClassName);
		}
	}
	// utility methods
	public Method[] getmethods() throws SecurityException, ClassNotFoundException {
		loadClass();
		Method[] methods = loadedClass.getDeclaredMethods();
		return methods;
	}
	

	// getters and setters
	public String getQualifiedClassName() {
		return qualifiedClassName;
	}

}
