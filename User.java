package Homework7;

// super class
public abstract class User {
	private String user;
	private String pass;
	private PhoneBookDirectory directory;
	
	// user constructor
	public User(String username, String password, PhoneBookDirectory directory) {
		this.user = username;
		this.pass = password;
		this.directory = directory;
	}

	// generated getters and setters
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public PhoneBookDirectory getDirectory() {
		return directory;
	}
	public void setDirectory(PhoneBookDirectory directory) {
		this.directory = directory;
	}

	// print user info
	public void PrintUserInfo() {
		System.out.println(user + " - " + pass);
	}
	
}
