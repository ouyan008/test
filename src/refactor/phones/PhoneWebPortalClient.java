/*Title: Damn it, George

Problem
============================
ACME Corporation has created an internal-facing web portal for their support group to use.
The support group needs the ability to suspend, resume, activate, and get the status of
different kinds of phones. The cell phone providers each have their own API on doing this.

Oh no! ACME has an unfortunate problem. George has decided to take a long vacation at
an unfortunate time. George was the developer who created and maintained the web portal.
It's an unfortunate time because ACME is introducing the ability to perform services on
Sprint phones and needs it done as soon as possible.

Luckily, they've hired you to look into it. Looking at the code, you see that it is not
well-written. Not only is it not very extensible, but George makes incorrect assumptions,
even though what he has written has worked with 100% success rate.

- Refactor the web portal so that it is easily extensible for Sprint (and future providers).

- Make the portal much more manageable for future developers.

- Afterwards, add the Sprint API calls to the portal so that ACME can meet its demands. 

Different APIs require different authentication methods (certificate, login) and some
may need to go through a special proxy. George's code will tell you which APIs need which. 


Do not change any files marked "DO NOT CHANGE".

REMEMBER - You CANNOT change the following files
 - NetworkUtils.java
 - PhoneWebPortalClient.java
 - AlltelAPIs.java
 - AttAPIs.java
 - SprintAPIs.java
 - TMobileAPIs.java
 - VerizonAPIs.java
*/
package refactor.phones;

/**
 * DO NOT CHANGE
 * 
 * Class to represent how a client/user interacts with the {@link PhoneWebPortal}.
 * This class is only here to show the interaction and sample calls.
 */
public class PhoneWebPortalClient {
	
	public static void main(String[] args) {
		PhoneWebPortal portal = new PhoneWebPortal();
		
		// Verizon
		portal.suspend("V984033", "VERIZON");
		portal.activate("V994003", "VERIZON");
		portal.resume("V032430", "VERIZON");
		portal.suspend("V093499", "VERIZON");
		
		// AT&T
		portal.activate("ATT93222", "AT&T");
		portal.suspend("ATT04343", "AT&T");
		portal.getStatus("ATT39336", "AT&T");
		portal.resume("ATT40888", "AT&T");
		portal.suspend("ATT49489", "AT&T");
		
		// T-Mobile
		portal.suspend("746321000TM", "TMOBILE");
		
		// Alltel
		portal.suspend("233966430000", "ALLTEL");
		portal.activate("974648370000", "ALLTEL");
		portal.getStatus("387594840000", "ALLTEL");
		
		// Sprint
		portal.resume("44458969", "SPRINT");
		portal.resume("34500037", "SPRINT");
	}
	
}
/**
 * DO NOT CHANGE
 */

