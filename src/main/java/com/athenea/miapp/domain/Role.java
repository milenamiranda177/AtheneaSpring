package com.athenea.miapp.domain;

public enum Role {
	USER("ROLE_USER"),
	ADMIN("ROLE_ADMIN");
	
	private String role;
	
	private Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
