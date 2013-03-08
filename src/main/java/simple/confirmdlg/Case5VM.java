package simple.confirmdlg;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;

public class Case5VM {

	String name = "Alex";

	// warp the UI interaction to a utility class by MVC
	// if the util could is a bean what create by some factory, then you have to chance
	// to isolate the ui form this view model.
	Case5Util util;
	
	@Init
	public void init(@ContextParam(ContextType.BINDER) Binder binder){
		util = new Case5Util(binder);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Command
	public void register() {
		util.showConfirm("Do you really want to register as " + name,"registerExecute");
	}
	
	@Command
	public void registerExecute() {
		util.showMessage("Thanks for registering, " + name);
	}
}
