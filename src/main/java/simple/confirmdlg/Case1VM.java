package simple.confirmdlg;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;

public class Case1VM {

	String name = "Alex";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Command
	public void register(@ContextParam(ContextType.BINDER) final Binder binder) {
		Messagebox.show("Do you really want to register as " + name, new Messagebox.Button[] { Messagebox.Button.YES
				, Messagebox.Button.CANCEL }, new EventListener<Messagebox.ClickEvent>() {
			public void onEvent(ClickEvent event) throws Exception {
				if(event.getButton()==Messagebox.Button.YES){
					binder.postCommand("registerExecute", null);
				}
			}
		});
	}

	@Command
	public void registerExecute() {
		Messagebox.show("Thanks for registering, " + name);
	}

}
