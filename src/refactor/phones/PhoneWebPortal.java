
package refactor.phones;

import java.io.File;

import refactor.phones.apis.AlltelAPIs;
import refactor.phones.apis.AttAPIs;
import refactor.phones.apis.TMobileAPIs;
import refactor.phones.apis.VerizonAPIs;

public class PhoneWebPortal {
	
	public void resume(String phoneId, String provider) {
		
		if (phoneId.startsWith("V")) {
			File cert = new File(PhoneWebPortal.class.getClassLoader().getResource("verizon.cert").getPath());
			VerizonAPIs.resume(cert, phoneId);
		}
		else if (phoneId.startsWith("ATT")) {
			AttAPIs.resume("generaleatt", "attPassword", phoneId);
		}
		else if (phoneId.endsWith("TM")) {
			NetworkUtils.setProxy(true);
			TMobileAPIs.resume("tmobilege", "tMobilePass", phoneId);
			NetworkUtils.setProxy(false); // turn back off
		}
		else {
			NetworkUtils.setProxy(true);
			AlltelAPIs.resume("gealltel", "runteldat", phoneId);
			NetworkUtils.setProxy(false);
		}
		
	}
	
	public void suspend(String phoneId, String provider) {
		
		if (phoneId.startsWith("V")) {
			File cert = new File(PhoneWebPortal.class.getClassLoader().getResource("verizon.cert").getPath());
			VerizonAPIs.suspend(cert, phoneId);
		}
		else if (phoneId.startsWith("ATT")) {
			AttAPIs.deactivate("generaleatt", "attPassword", phoneId);
		}
		else if (phoneId.endsWith("TM")) {
			NetworkUtils.setProxy(true);
			TMobileAPIs.suspend("tmobilege", "tMobilePass", phoneId);
			NetworkUtils.setProxy(false); // turn back off
		}
		else {
			NetworkUtils.setProxy(true);
			AlltelAPIs.pause("gealltel", "runteldat", phoneId);
			NetworkUtils.setProxy(false);
		}
		
	}
	
	public void activate(String phoneId, String provider) {
		
		if (phoneId.startsWith("V")) {
			File cert = new File(PhoneWebPortal.class.getClassLoader().getResource("verizon.cert").getPath());
			VerizonAPIs.activate(cert, phoneId);
		}
		else if (phoneId.startsWith("ATT")) {
			AttAPIs.activate("generaleatt", "attPassword", phoneId);
		}
		else if (phoneId.endsWith("TM")) {
			NetworkUtils.setProxy(true);
			TMobileAPIs.activate("tmobilege", "tMobilePass", phoneId);
			NetworkUtils.setProxy(false); // turn back off
		}
		else {
			NetworkUtils.setProxy(true);
			AlltelAPIs.play("gealltel", "runteldat", phoneId);
			NetworkUtils.setProxy(false);
		}
		
	}
	
	
	public boolean getStatus(String phoneId, String provider) {
		
		if (phoneId.startsWith("V")) {
			File cert = new File(PhoneWebPortal.class.getClassLoader().getResource("verizon.cert").getPath());
			return VerizonAPIs.getStatus(cert, phoneId);
		}
		else if (phoneId.startsWith("ATT")) {
			return AttAPIs.getStatus("generaleatt", "attPassword", phoneId);
		}
		else if (phoneId.endsWith("TM")) {
			NetworkUtils.setProxy(true);
			boolean s = TMobileAPIs.getStatus("tmobilege", "tMobilePass", phoneId);
			NetworkUtils.setProxy(false); // turn back off
			return s;
		}
		else {
			NetworkUtils.setProxy(true);
			boolean s = AlltelAPIs.isTurnedOn("gealltel", "runteldat", phoneId);
			NetworkUtils.setProxy(false);
			return s;
		}
		
	}
	
}
