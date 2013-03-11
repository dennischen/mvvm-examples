package simple.confirmdlg;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zul.Messagebox;

public class Case7VM {

	String name = "Alex";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConfirmRegisterMessage(){
		return "do you really want to register as "+ name;
	}
	
	
	@Command
	public void register(@ContextParam(ContextType.BINDER) final Binder binder) {
		Messagebox.show("Thanks for registering, " + name);
	}

}
