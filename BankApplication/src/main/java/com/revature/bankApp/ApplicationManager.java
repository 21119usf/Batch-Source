package com.revature.bankApp;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
	private Map<Application, User> userApplicationMap = new HashMap<Application, User>();
	
	public void createNewApplication(User user) {
		Application application = new Application(user);
		
		userApplicationMap.put(application, user);
	}
	
	public void approveApplication(Application application, CustomerFunctions manager, MappingAccountAndUser manageAccountAndUser) {
		application.setStatus(true);   // application is set to true automatically
		manageAccountAndUser.addNewAccount(application.getCustomer(), 0, manager);  //getting the new user to create new account and set the balance to zero
		userApplicationMap.remove(application); //then removing the said applications that were approved
	}
	
	public Map<Application, User> getApplicationMap(){
		return userApplicationMap;
	}
	
}
