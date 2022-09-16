package com.bridgelabz.addressbook.main;

public class ContactPerson {

	private String firstName;
	private String lastName;
	private String type;
	private String address;
	private String city;
	private String state;
	private double phoneNumber, zip;
	private String email;
	private String date;

	public ContactPerson() {

	}

	public ContactPerson(String firstName, String lastName, String type, String address, String city, String state,
			double phoneNumber, double zip, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.zip = zip;
		this.email = email;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getZip() {
		return zip;
	}

	public void setZip(double zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ContactPerson [firstName=" + firstName + ", lastName=" + lastName + ", type=" + type + ", address="
				+ address + ", city=" + city + ", state=" + state + ", phoneNumber=" + phoneNumber + ", zip=" + zip
				+ ", email=" + email + "]";
	}

}
