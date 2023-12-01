package Homework7;

public class PhoneBookEntry {
	// declare private var
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String zipCode;
	private String phoneNumber;
	
	// default constructor
	public PhoneBookEntry() {
		this.id = -1;
	}
	
	// constructor that uses all attributes
	public PhoneBookEntry (int id, String firstName, String lastName, String email, String zipCode, String phoneNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}
	
	// constructor for fname and number only
	public PhoneBookEntry (String firstName, String phoneNumber) {
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
	}
	
	// constructor for fname only
	public PhoneBookEntry (String firstName) {
		this.firstName = firstName;
	}
	
	// getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// prints all the data fields
	public void printBookEntry() {
		System.out.println( id + ", " + firstName + ", " + lastName + ", " + email
				+ ", " + zipCode + ", " + phoneNumber);
	}
	
}
