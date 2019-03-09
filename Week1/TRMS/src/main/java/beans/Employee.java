package beans;

public class Employee {
	private int employee_id;
	private String firstname, lastname, username, password, email;
	private double leftover;
	private int supervisor_id;
	private int clearence;
	
	public Employee() {
		super();
	}

	public Employee(int id, String firstname, String lastname, String username, String password, String email,
			double leftover, int supervisor, int clearence) {
		super();
		this.employee_id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.leftover = leftover;
		this.supervisor_id = supervisor;
		this.clearence = clearence;
	}

	public Employee(int id, String firstname, String lastname, String username, String password, String email,
			double leftover, int clearence) {
		super();
		this.employee_id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.leftover = leftover;
		this.clearence = clearence;
	}

	public int getId() {
		return employee_id;
	}

	public void setId(int id) {
		this.employee_id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getLeftover() {
		return leftover;
	}

	public void setLeftover(double leftover) {
		this.leftover = leftover;
	}

	public int getSupervisor() {
		return supervisor_id;
	}

	public void setSupervisor(int supervisor) {
		this.supervisor_id = supervisor;
	}

	public int getClearence() {
		return clearence;
	}

	public void setClearence(int clearence) {
		this.clearence = clearence;
	}

	@Override
	public String toString() {
		return "Employee [id: " + employee_id + ", firstname: " + firstname + ", lastname: " + lastname + ", username: " + username
				+ ", password: " + password + ", email: " + email + ", leftover: " + leftover + ", supervisor: "
				+ supervisor_id + ", clearence: " + clearence + "]";
	}
	
	
}
