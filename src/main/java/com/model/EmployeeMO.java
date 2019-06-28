package com.model;

public class EmployeeMO {

	private long id;
	private String email;
	private String name;

	public EmployeeMO() {
		super();
	}

	public EmployeeMO(long id, String email, String name) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmployeeMO [id=" + id + ", email=" + email + ", name=" + name
				+ "]";
	}

}
