package exception.propagation;

import java.io.IOException;

public abstract class AbstractSampleClass {
	public abstract void test() throws NullPointerException;
	
	public abstract void test2() throws IOException;
}
