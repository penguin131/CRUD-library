package myApp.model;

import java.security.Principal;

public class Role implements Principal {

	private String name;

	public Role(String name) {
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
