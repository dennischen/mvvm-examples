package simple.opendlg;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

public class Case2VM {

	String value = "Say something";
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}



	@Command
	public void open(){
		Map<String,Object> arg = new HashMap<String,Object>();
		Case2DlgVM dlgVm = new Case2DlgVM();
		dlgVm.setValue(value);
		arg.put("dlgVm", dlgVm);
		Executions.createComponents("/opendlg/case2Dlg.zul", null,arg);
	}
	
	@GlobalCommand @NotifyChange("value")
	public void dlgClose(@BindingParam("dlgVm")Case2DlgVM dlgVm){
		this.value = dlgVm.getValue();
	}
}
