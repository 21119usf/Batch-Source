package com.revature.person;

import java.io.Serializable;
//
public abstract class Person implements Serializable {

	private static final long serialVersionUID = 5439497178671606437L;
			private String firstName;
			private String lastName;
			private long ssn;
			
			public String getFirstName() {
				return firstName;
			}
			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}
			public String getLastName() {
				return lastName;
			}
			public void setLastName(String lastName) {
				this.lastName = lastName;
			}
			public long getSsn() {
				return ssn;
			}
			public void setSsn(long ssn) {
				this.ssn = ssn;
			}

}
