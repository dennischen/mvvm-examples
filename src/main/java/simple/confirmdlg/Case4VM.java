package simple.confirmdlg;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;

public class Case4VM {

	String name = "Alex";
	
	Case4Util util;

	@Init
	public void init(@ContextParam(ContextType.BINDER) Binder binder){
		util = new Case4Util(binder);
	}
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
		util.showConfirm("Do you really want to register as " + name,"registerExecute");
	}

	@Command
	public void registerExecute() {
		util.setMessage("Thanks for registering, "+name);
	}


}
