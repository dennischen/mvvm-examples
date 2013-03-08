package simple.messagebox;

import org.zkoss.bind.annotation.Command;

public class Case4VM {

	String name = "Alex";
	
	Case4Util util = new Case4Util(); 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Case4Util getUtil(){
		return util;
	}


	@Command
	public void register() {
		util.showMessage("Thanks for registering, "+name);
	}


}
