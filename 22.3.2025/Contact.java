package com.project.HibernateProject;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {
	private int contactId;
	
	private String phone;
	private String city;
	private String state;
	private int pin;

	public Contact(){
		
	}

	public Contact(String phone, String city, String state, int pin) {
	
		
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", phone=" + phone + ", city=" + city + ", state=" + state + ", pin="
				+ pin + "]";
	}

	
	
	
}