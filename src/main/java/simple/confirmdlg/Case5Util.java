package simple.confirmdlg;

import org.zkoss.bind.Binder;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;


/**
 * 
 * @author dennis
 *
 */
public class Case5Util {

	Binder binder;
	public Case5Util(Binder binder) {
		this.binder = binder;
	}

	public void showMessage(String message) {
		//both Messagebox.sho and createComponent are available here
		Messagebox.show(message);
	}
	

	public void showConfirm(String message,final String actionCommand) {
		//both Messagebox.sho and createComponent are available here
		Messagebox.show(message, new Messagebox.Button[] { Messagebox.Button.YES
				, Messagebox.Button.CANCEL }, new EventListener<Messagebox.ClickEvent>() {
			public void onEvent(ClickEvent event) throws Exception {
				if(event.getButton()==Messagebox.Button.YES){
					binder.postCommand(actionCommand, null);
				}
			}
		});
	}
}
