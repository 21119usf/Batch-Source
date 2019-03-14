package com.revature.beans;

import java.util.List;

import com.revature.Dao.CheckStatusDaoImpl;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException {
//		FormsDaoImpl getForm = new FormsDaoImpl();
//		ReimbursementForm form = getForm.getStudentForm(31);
//		System.out.println(form.getFname()+"|"+form.getLname()+"|"+form.getStreet()+"|"+ form.getCity()+"|"+form.getState()
//		+"|"+form.getZipCode()+"|"+form.getPhoneNumber()+"|"+form.getEmail()+"|"+form.getsID());

//		LoginDaoImpl login = new LoginDaoImpl();
//		User user = new User("student1","Easypass");
//		boolean status = login.studentLogin(user);
//		System.out.println(status);
		
//		String url = "http://localhost:8080/webPractice/html2";
//		System.out.println(url.contains("html2"));
		
//		FormsDaoImpl getForm = new FormsDaoImpl();
//		List<Object> form= getForm.getReimbursementInfo(31);
//		ReimbursementForm rForm = (ReimbursementForm)form.get(0);
//		Employee employee = (Employee)form.get(1);
//		Student student  = (Student)form.get(2);
//		System.out.println(rForm.getCost());
//		System.out.println(employee.getFname());
//		System.out.println(student.getFname());
//		System.out.println(form.size());
//		
		CheckStatusDaoImpl check = new CheckStatusDaoImpl();
		String status = check.checkStatus(31);
		//System.out.println((String)status.get(0));
		System.out.println(status);
		
//		User user = new User("31");
//		System.out.println(user.getUserID());
		
	}	

}
