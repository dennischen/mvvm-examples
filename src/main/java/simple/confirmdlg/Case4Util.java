package simple.confirmdlg;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class Case4Util {

	String message;

	String confirmMessage;

	String confirmAction;
	
	Binder binder;
	
	public Case4Util(Binder binder){
		this.binder = binder;
	}

	public String getMessage() {
		return message;
	}

	public String getConfirmMessage() {
		return confirmMessage;
	}

	public String getConfirmAction() {
		return confirmAction;
	}

	public void setConfirmAction(String confirmAction) {
		this.confirmAction = confirmAction;
		
	}

	public void setMessage(String message) {
		this.message = message;
		BindUtils.postNotifyChange(null, null, this, "message");
	}

	@Command
	@NotifyChange("message")
	public void clearMessage() {
		message = null;
	}
	
	@Command
	@NotifyChange("confirmMessage")
	public void clearConfirmMessage() {
		confirmMessage = null;
	}
	
	@Command
	@NotifyChange("confirmMessage")
	public void confirm() {
		confirmMessage = null;
		binder.postCommand(confirmAction, null);
	}

	public void showConfirm(String confirmMessage,String confirmAction) {
		
		this.confirmMessage = confirmMessage;
		BindUtils.postNotifyChange(null, null, this, "confirmMessage");
		
		this.confirmAction = confirmAction;
	}
}
