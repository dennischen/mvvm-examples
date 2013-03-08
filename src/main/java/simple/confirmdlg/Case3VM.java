package simple.confirmdlg;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class Case3VM {

	String name = "Alex";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String message;

	String confirmMessage;

	String confirmAction;

	public String getMessage() {
		return message;
	}

	public String getConfirmMessage() {
		return confirmMessage;
	}

	public String getConfirmAction() {
		return confirmAction;
	}

	@Command
	@NotifyChange({"confirmMessage","confirmAction"})
	public void register() {
		confirmMessage = "Do you really want to register as " + name;
		confirmAction = "registerExecute";
	}

	@Command
	@NotifyChange("message")
	public void registerExecute() {
		message = "Thanks for registering, " + name;
	}

	@Command
	@NotifyChange({"message","confirmMessage"})
	public void clearMessage() {
		message = null;
		confirmMessage = null;
	}
}
