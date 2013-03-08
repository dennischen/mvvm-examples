package simple.messagebox;

import org.zkoss.bind.Binder;
import org.zkoss.zul.Messagebox;


/**
 * 
 * @author dennis
 *
 */
public class Case5Util {

	public void showMessage(String message) {
		//both Messagebox.sho and createComponent are available here
		Messagebox.show(message);
	}
}
