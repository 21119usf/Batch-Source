package banking.controllers;

public abstract class BaseController<T> {
	
	public abstract T NEW(String ... args);
	
	public abstract T CREATE(String ... args);
	
	public abstract T SHOW(String ... args);
	
	public abstract void INDEX(String ... args);
	
	public abstract T EDIT(String ... args);
	
	public abstract T UPDATE(T arg);
	
	public abstract void DELETE(String ... args);

}
