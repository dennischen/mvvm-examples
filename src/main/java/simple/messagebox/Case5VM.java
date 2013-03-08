package simple.messagebox;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

public class Case5VM {

	String name = "Alex";

	// warp the UI interaction to a utility class by MVC
	// if the util could is a bean what create by some factory, then you have to chance
	// to isolate the ui form this view model.
	Case5Util util;
	
	@Init
	public void init(){
		util = new Case5Util();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Command
	public void register() {
		util.showMessage("Thanks for registering, " + name);
	}

}
