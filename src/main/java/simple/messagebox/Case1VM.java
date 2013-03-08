package simple.messagebox;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zul.Messagebox;

public class Case1VM {

	String name = "Alex";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Command
	public void register() {
		Messagebox.show("Thanks for registering, " + name);
	}

}
