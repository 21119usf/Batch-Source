package banking.controllers;

import banking.beans.Admin;

public class AdminsController extends BaseController<Admin> {
	
	private static AdminsController instance;
	private AdminsController() {
	}
	
	public static AdminsController getInstance(){
		if(instance == null)
			instance = new AdminsController();
		return instance;	
	}

	@Override
	public Admin NEW(String... args) {
		// no admins will be created through app
		return null;
	}

	@Override
	public Admin CREATE(String... args) {
		// no admin creation
		return null;
	}

	@Override
	public Admin SHOW(String... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void INDEX(String... args) {
		// no admin list?
		
	}

	@Override
	public Admin EDIT(String... args) {
		// no admin editing
		return null;
	}

	@Override
	public Admin UPDATE(Admin arg) {
		// no admin update
		return null;
	}

	@Override
	public void DELETE(String... args) {
		// can't delete admins
		
	}
	
	

}
