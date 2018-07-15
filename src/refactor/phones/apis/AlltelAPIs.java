
package refactor.phones.apis;

import java.util.Random;

/**
 * DO NOT CHANGE
 * 
 * This class mocks/represents an external API call.
 */
public class AlltelAPIs {
	
	public static void resume(String username, String password, String phoneId) {
		// do nothing
	}
	
	public static void pause(String username, String password, String phoneId) {
		// do nothing
	}
	
	public static void play(String username, String password, String phoneId) {
		// do nothing
	}
	
	public static boolean isTurnedOn(String username, String password, String phoneId) {
		return new Random().nextBoolean();
	}
	
}