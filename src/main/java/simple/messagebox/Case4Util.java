package simple.messagebox;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class Case4Util {

	String message;

	public String getMessage() {
		return message;
	}

	public void showMessage(String message) {
		this.message = message;
		BindUtils.postNotifyChange(null, null, this, "message");
	}
	
	@Command
	@NotifyChange("message")
	public void clearMessage(){
		message = null;
	}
}
