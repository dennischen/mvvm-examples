package simple.confirmdlg;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;

public class Case2VM {

	String name = "Alex";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Command
	public void register(@ContextParam(ContextType.BINDER) final Binder binder) {
		Map args = new HashMap();
		args.put("message", "Do you really want to register as " + name);
		args.put("callback", new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				binder.postCommand("registerExecute", null);
			}
		});
		Executions.createComponents("/confirmdlg/case2ConfirmDlg.zul", null, args);
	}

	@Command
	public void registerExecute() {
		Messagebox.show("Thanks for registering, " + name);
	}

}
