package es.salesianos.model;

import java.util.Date;

public class Company {

	private String name;
	private Date creationdate;

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
}
