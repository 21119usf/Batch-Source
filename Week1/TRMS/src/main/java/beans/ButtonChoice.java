package beans;

public class ButtonChoice {
	private int id;
	private String btn;
	
	@Override
	public String toString() {
		return "ButtonChoice [id=" + id + ", choice=" + btn + "]";
	}

	public ButtonChoice() {
		super();
	}

	public ButtonChoice(int id, String btn) {
		super();
		this.id = id;
		this.btn = btn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getbtn() {
		return btn;
	}

	public void setbtn(String btn) {
		this.btn = btn;
	}
	
}
