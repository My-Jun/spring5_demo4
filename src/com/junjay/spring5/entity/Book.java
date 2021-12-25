package com.junjay.spring5.entity;

public class Book {

	private String userId;
	private String userName;
	private String state;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Book(String userId, String userName, String state) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.state = state;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [userId=" + userId + ", userName=" + userName + ", state=" + state + "]";
	}

}
