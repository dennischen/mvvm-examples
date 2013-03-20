package simple.confirmdlg;

import org.zkoss.bind.Binder;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;

public class Case6ConfirmableValidator extends AbstractValidator{

	private final String CONFIRMMING = Case6ConfirmableValidator.class.getName()+".Confirming";
	
	public void validate(ValidationContext ctx) {
		//do your validation
		
		//handle necessary confirm
		handleConfirm(ctx);
	}
	
	protected void handleConfirm(ValidationContext ctx){
		handleConfirm(ctx,null);
	}
	protected void handleConfirm(ValidationContext ctx,String message){
		if(!ctx.isValid()) return;
		
		final String cmd = ctx.getCommand();
		final Binder binder = ctx.getBindContext().getBinder();
		final Component comp = ctx.getBindContext().getComponent();

		
		if (comp.hasAttribute(CONFIRMMING)) {
			comp.removeAttribute(CONFIRMMING);
		} else {
			ctx.setInvalid();
			comp.setAttribute(CONFIRMMING,"");
			
			if(message==null){
				message = getConfirmationMessage(ctx);
			}

			if(message==null){
				throw new UiException("message for confirming not found");
			}
			
			Messagebox.show(message, new Messagebox.Button[] { Messagebox.Button.YES,
					Messagebox.Button.CANCEL }, new EventListener<Messagebox.ClickEvent>() {
				public void onEvent(ClickEvent event) throws Exception {
					if (event.getButton() == Messagebox.Button.YES) {
						binder.postCommand(cmd, null);
					} else {
						comp.removeAttribute(CONFIRMMING);
					}
				}
			});

		}
	}

	private String getConfirmationMessage(ValidationContext ctx) {
		Object message = ctx.getValidatorArg("message");
		return message==null?null:message.toString();
	}
}
