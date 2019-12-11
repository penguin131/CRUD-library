package myApp.model;

import java.security.Principal;

public class User implements Principal {

	private String name;

	public User(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
