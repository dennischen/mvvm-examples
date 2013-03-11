To show a messagebox in ViewModel

*Case 1 : 
	//regular message box
	1.use Messagebox.show(message);  
*Case 2 : 
	//custom message box
	1.use Executions.createComponents(url, null, messageArg);
	2.custom messagebox is MVC to show a modal message box, it handle close inside it self directly

Case 3 :
	//custom message box by pure MVVM
	1.define message as a member field of ViewModel
	2.a custom messagebox which is binding to message to control the visibility and inside main function zul directly
	
Case 4 :
	//custom message box by Utility
	1.define Util bean to control the message state 
	2.the use Util bean as a member field of ViewModel
	3.a custom messagebox which is binding to bean to control the visibility, inside 2nd zul and include by main zul. 
	
*Case 5 :
	//custom message box by Utility
	1.define Util bean to control the message displaying directly 
	2.ViewModel use the Util bean to isolate UI manipulation behavior, the bean could be fake and do nothing in testing.