package simple.opendlg;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

public class Case1VM {

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
		arg.put("param1", value);
		Executions.createComponents("/opendlg/case1Dlg.zul", null,arg);
	}
	
	@GlobalCommand @NotifyChange("value")
	public void dlgClose(@BindingParam("result")String result){
		this.value = result;
	}
}
