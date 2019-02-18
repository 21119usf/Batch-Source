package com.revature.bankapp;


public class Application {
	@Override
	public String toString() {
		return "Application [appId=" + appId + "]";
	}
	private int appId;
    static int counter = 0;
    
	public int getAppId() {
		return appId;
	}
	public Application() {
		super();
		this.appId = Application.counter++ ;
	}
	public Application(int application) {
		super();
		this.appId = application;
		Application.counter = appId + 1;
	}

}
