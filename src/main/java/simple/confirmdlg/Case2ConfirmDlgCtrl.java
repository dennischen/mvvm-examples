package simple.confirmdlg;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;

public class Case2ConfirmDlgCtrl extends SelectorComposer<Component> {

	@Wire
	Button yesBtn;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		EventListener callback = (EventListener) Executions.getCurrent().getArg().get("callback");
		yesBtn.addEventListener(Events.ON_CLICK, callback);
	}

	@Listen("onClick = #noBtn;onClick = #yesBtn")
	public void close() {
		getSelf().detach();
	}

}
