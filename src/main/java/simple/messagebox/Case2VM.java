package simple.messagebox;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;

public class Case2VM {

	String name = "Alex";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Command
	public void register() {
		Map arg = new HashMap();
		arg.put("message", "Thanks for registering, "+name);
		Executions.createComponents("/messagebox/case2MessageDlg.zul", null, arg);
	}

}
