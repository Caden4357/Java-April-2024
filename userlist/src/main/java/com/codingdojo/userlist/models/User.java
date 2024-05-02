package com.codingdojo.userlist.models;

public class User {
	private String name;
	private int age;
	private boolean isAdult;
	
	
	public User(String name, int age, boolean isAdult) {
		this.name = name;
		this.age = age;
		this.isAdult = isAdult;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public boolean isAdult() {
		return isAdult;
	}


	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}
	
	
	

}
