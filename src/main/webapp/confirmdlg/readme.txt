To show a confirmation dlg in ViewModel

* Case 1 : 
	//split execution to confirm & execute command and use regular confirmation dlg
	1.the first command is just for showing dlg. use Messagebox.show(message,listener) to show the dlg
	2.the listener posts 2nd command which will execute the actual command.
* Case 2 : 
	//split execution to confirm & execute command and use custom confirmation dlg
	1.the first command is just for showing dlg. use Executions.createComponents(url, null, messageAnCallbackArg); to show the dlg
	2.custom dlg is MVC to show a modal confirmation window, it handle close inside it-self directly, 
	  it forwards the event to callback listener in view model
	3.the listener posts 3nd command which will execute the actual command.

Case 3 :
	//split execution to confirm & execute command and use custom confirmation box by pure MVVM
	1.define confirm-message/confirm-action as a member field of ViewModel
	2.the first command is just for showing dlg
	3.a custom dlg which is binding to the message to control the visibility and inside main zul directly
	4.send confirm-action when clicking on the Yes button of the dlg.
	
Case 4 :
	//split execution to confirm & execute command and use custom confirmation box by Utility 
	1.define Util bean to control the confrim-message/confirm-action state
	2.the first command is just for showing dlg 
	4.the use Util bean as a member field of ViewModel
	5.a custom dlg which is binding util to control the visibility, inside 2nd zul and include by main zul.
	6.post confirm-action when clicking on the Yes button of the dlg.
	
Case 5 :
	//split execution to confirm & execute command and use custom confirmation box by Utility
	1.define Util bean to control the confirmation & message displaying directly
	2.the first command is just for showing dlg 
	3.ViewModel use the util bean to isolate UI manipulation behavior
	4.post confirm-action when user finish the confirmation.	
	ISSUE:
		* how to pass binder to Util to post command
	
Case 6 :
	//custom confirmation box by Utility
	1.a utility validator to help the confirmation break and re-post
	2.ViewModel doesn't need to split the command to confirm & execute
	3.post action again when user finish the confirmation.
	ISSUE:
		* if there has other validator
		* how to passing message that related to current vm
		
* Case 7:
	//zk support it directly
	1. and zk support annotation.