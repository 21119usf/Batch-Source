package bankingViews;

public class ViewMaker {

	public View determineNextView(String input)
	{
		View nextView = null;
		
		switch (input)
		{
		case "login" : 
			nextView = new LoginView();
			break;
			
		case "user" : 
			nextView = new UserView();
			break;

		case "admin" :
			nextView = new AdminView();
			break;
			
		case "new" :
			nextView = new NewView();
			break;
								
		case "update" :
			nextView = new UpdateView();
			break;
			
		default :
			System.out.println("View not found");
		}
		
		
		return nextView;
	}
}
