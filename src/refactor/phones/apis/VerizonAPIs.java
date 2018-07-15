package refactor.phones.apis;

import java.io.File;
import java.util.Random;

/**
 * DO NOT CHANGE
 * 
 * This class mocks/represents an external API call.
 */
public class VerizonAPIs {
	
	public static void resume(File certificate, String phoneId) {
		// do nothing
	}
	
	public static void suspend(File certificate, String phoneId) {
		// do nothing
	}
	
	public static void activate(File certificate, String phoneId) {
		// do nothing
	}
	
	public static boolean getStatus(File certificate, String phoneId) {
		return new Random().nextBoolean();
	}
	
}
/**
 * DO NOT CHANGE
 */
