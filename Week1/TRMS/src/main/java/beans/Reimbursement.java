package beans;

import java.sql.Date;

public class Reimbursement {
	private int reimbursement_id;
	private int employee_id;
	private Date date;
	private int approvalStatus;
	private double cost;
	private String location;
	private int gradingFormat;
	private int eventType;
	private String justification;
	private int inCharge;
	private String denyReason;
	
	
	public Reimbursement() {
		super();
	}
	
	public int getId() {
		return reimbursement_id;
	}
	public void setId(int id) {
		this.reimbursement_id = id;
	}
	public int getEmployeeId() {
		return employee_id;
	}
	public void setEmployeeId(int employeeId) {
		this.employee_id = employeeId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(int gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public int getEventType() {
		return eventType;
	}
	public void setEventType(int eventType) {
		this.eventType = eventType;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public int getInCharge() {
		return inCharge;
	}
	public void setInCharge(int inCharge) {
		this.inCharge = inCharge;
	}
	public String getDenyReason() {
		return denyReason;
	}
	public void setDenyReason(String denyReason) {
		this.denyReason = denyReason;
	}
	public Reimbursement(int id, int employeeId, Date date, int approvalStatus, double cost, String location,
			int gradingFormat, int eventType, String justification, int inCharge, String denyReason) {
		super();
		this.reimbursement_id = id;
		this.employee_id = employeeId;
		this.date = date;
		this.approvalStatus = approvalStatus;
		this.cost = cost;
		this.location = location;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.justification = justification;
		this.inCharge = inCharge;
		this.denyReason = denyReason;
	}
	
	
}
