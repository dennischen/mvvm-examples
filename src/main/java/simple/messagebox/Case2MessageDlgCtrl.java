package simple.messagebox;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class Case2MessageDlgCtrl extends SelectorComposer<Component> {

	@Listen("onClick = #closeBtn")
	public void close() {
		getSelf().detach();
	}

}
