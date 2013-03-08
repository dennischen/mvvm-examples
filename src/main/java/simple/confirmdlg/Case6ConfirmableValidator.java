package simple.confirmdlg;

import org.zkoss.bind.Binder;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;

public class Case6ConfirmableValidator extends AbstractValidator{

	public void validate(ValidationContext ctx) {
		final String cmd = ctx.getCommand();
		final Binder binder = ctx.getBindContext().getBinder();
//		final String triggerEvent = ctx.getBindContext().getTriggerEvent().getName();
		final Component comp = ctx.getBindContext().getComponent();
		
		
		if(ctx.isValid()){
			if(comp.hasAttribute("inConfirm")){
				comp.removeAttribute("inConfirm");
			}else{
				ctx.setInvalid();
				comp.setAttribute("inConfirm", Boolean.TRUE);
				
				Messagebox.show("Do you really want to register", new Messagebox.Button[] { Messagebox.Button.YES
						, Messagebox.Button.CANCEL }, new EventListener<Messagebox.ClickEvent>() {
					public void onEvent(ClickEvent event) throws Exception {
						if(event.getButton()==Messagebox.Button.YES){
							binder.postCommand(cmd, null);
						}else{
							comp.removeAttribute("inConfirm");
						}
					}
				});
				
			}
		}
	}
	
	

}
