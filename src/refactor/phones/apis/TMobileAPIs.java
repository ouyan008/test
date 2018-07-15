package refactor.phones.apis;

import java.util.Random;

/**
 * DO NOT CHANGE
 * 
 * This class mocks/represents an external API call.
 */
public class TMobileAPIs {
	
	public static void resume(String username, String password, String phoneId) {
		// do nothing
	}
	
	public static void suspend(String username, String password, String phoneId) {
		// do nothing
	}
	
	public static void activate(String username, String password, String phoneId) {
		// do nothing
	}
	
	public static boolean getStatus(String username, String password, String phoneId) {
		return new Random().nextBoolean();
	}
	
}
/**
 * DO NOT CHANGE
 */
