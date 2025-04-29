package org.darktech.dto;


public class LoginResponse {
	private String token;
	private UserResponseDTO user;

	public LoginResponse() {
	}

	
	public LoginResponse(String token, UserResponseDTO user) {
		this.token = token;
		this.user = user;
	}


	public UserResponseDTO getUser() {
		return user;
	}


	public void setUser(UserResponseDTO user) {
		this.user = user;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
}
