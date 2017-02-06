package exception.propagation;

import java.io.IOException;
/*
 * If parent method throws subclass of runtime exception, child can declare RuntimeException
 * If parent method throws any checked exception, child cannot declare Exception
 */
public class SampleClassImpl extends AbstractSampleClass{

	@Override
	public void test() throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test2() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
