package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Rajan Prasad Upadhyay
 *
 */
public class LogExample {
    private final static Logger LOGGER = Logger.getLogger(LogExample.class .getName());
    
    public static void main(String[] args) {
    	String a = "a";
    	String b = "a";
    	
    	//amazing things
    	if(a == "a"){
    		System.out.println("a == b");
    	}else{
    		System.out.println("a!=b");
    	}
    	
	/* 
	 * sever
	 * warning
	 * info
	 * 
	 * config
	 * fine
	 * finer
	 * finest
	 */
	LOGGER.setLevel(Level.FINEST);
	
	try {
	    FileHandler fileH = new FileHandler("Log.txt");
	    LOGGER.addHandler(fileH);
	} catch (SecurityException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
//	LOGGER.severe(Thread.currentThread().getId()+"::::"+"This is a severe log");
//	LOGGER.warning("HMM I am angry and this is a warning");
//	LOGGER.info("I want to provide you with some information");
	LOGGER.config("Configure yourself otherwise");
	LOGGER.fine("I am fine <hhhh>");
	LOGGER.finer("I am finer now");
	LOGGER.fine("I am the best");
    }
}
