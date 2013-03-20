package simple.confirmdlg;

import org.zkoss.bind.Binder;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;

public class Case6VM {

	String name = "Alex";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Validator getConfirmableValidator(){
		return new Case6ConfirmableValidator();
	}

	@Command
//	@Validator()
	public void register(@ContextParam(ContextType.BINDER) final Binder binder) {
		Messagebox.show("Thanks for registering, " + name);
	}

}
