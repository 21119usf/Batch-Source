package banking.controllers;

import banking.beans.Employee;

public class EmployeesController  extends BaseController<Employee> {
	
	private static EmployeesController instance;
	private EmployeesController() {
	}
	
	public static EmployeesController getInstance(){
		if(instance == null)
			instance = new EmployeesController();
		return instance;	
	}

	@Override
	public Employee NEW(String... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee CREATE(String... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee SHOW(String... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void INDEX(String... args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee EDIT(String... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee UPDATE(Employee arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DELETE(String... args) {
		// TODO Auto-generated method stub
		
	}

}
