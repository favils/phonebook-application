package Homework7;
import java.io.*;
import java.util.*;

// interface for PhoneBookAdmin
interface PhoneAdmin {
	public int addEntry();
	public int Edit();
	public int DeleteEntry();
	public int LinearSearchByPhoneNumber();
	public PhoneBookEntry SearchbyIdBinarySearch();
	public void sortDir();
	public void PrintUserInfo();
	public void changePassword();
	public void changeUsername();
}

public class PhoneBookAdmin extends User implements PhoneAdmin {
	//has a username, password, emailAddress (string) and a PhoneBookDirectory
	private String user;
	private String pass;
	private String email;
	private PhoneBookDirectory dir;
	private Scanner myS;
	
	// constructor that calls super class
	public PhoneBookAdmin(String user, String pass, String email, PhoneBookDirectory dir) {
		super(user,pass,dir);
		this.email = email;
		myS = new Scanner(System.in);
	}

	// admin menu
	public void adminMenu() {
		System.out.println("Choose an option:");
        System.out.println("1. Add an entry");
        System.out.println("2. Edit an entry");
        System.out.println("3. Delete an entry");
        System.out.println("4. Sort Entries");
        System.out.println("5. Search for an entry using Linear Search by Phone Number");
        System.out.println("6. Search for an entry using Binary Search by phone number");
        System.out.println("7. Print Admin Info");
        System.out.println("8. Change Password");
        System.out.println("9. Change Username");
        System.out.println("0. Quit");
	}
	
	// runAdmin after logging in Application class
	public void runAdmin() {
		
		adminMenu();
		int choice = myS.nextInt();

        while (choice != 0) {
        	if (choice == 1) {
                addEntry();
        	} else if (choice == 2) {
        		Edit();
        	} else if (choice == 3) {
                DeleteEntry();
        	} else if (choice == 4) {
                sortDir();
        	} else if (choice == 5) {
                LinearSearchByPhoneNumber();
        	} else if (choice == 6) {
                SearchbyIdBinarySearch();
        	} else if (choice == 7) {
                PrintUserInfo();
        	} else if (choice == 8) {
                changePassword();
        	} else if (choice == 9) {
                changeUsername();
        	} 
        	adminMenu();
    		choice = myS.nextInt();
        }
        System.out.println("Goodbye!");
    }

	// add method 
	public int addEntry() {
		// declare var
		int id;
		String firstName, lastName, email, zipCode, phoneNumber;
					
		// prompts for user
		System.out.println("Enter id:");
		id = myS.nextInt();
		myS.nextLine();
		System.out.println("Enter first name:");
		firstName = myS.nextLine();
		System.out.println("Enter last name:");
		lastName = myS.nextLine();
		System.out.println("Enter email:");
		email = myS.nextLine();
		System.out.println("Enter zip code:");
		zipCode = myS.nextLine();
		System.out.println("Enter phone number:");
		phoneNumber = myS.nextLine();
		
		// new phonebookentry object
		PhoneBookEntry newEntry = new PhoneBookEntry(id,firstName,lastName,email,zipCode,phoneNumber);
	
		// return values
		return getDirectory().addEntry(newEntry);
	}
		
	// edit method
	public int Edit() {
		myS.nextLine();
		
		// prompts for parameter in edit method
		System.out.println("Enter first name:");
		String fname = myS.nextLine();
		System.out.println("Enter last name:");
		String lname = myS.nextLine();
		
		// return values
		return getDirectory().Edit(fname, lname);
	}

	// delete method
	public int DeleteEntry() {
		
		// prompt for parameter
		System.out.println("Enter ID for entry to delete:");
		int deleteID = myS.nextInt();
		
		// return values
		return getDirectory().DeleteEntry(deleteID);
	}

	// linear search method
	public int LinearSearchByPhoneNumber() {
		
		// prompt for parameter
		System.out.println("Enter Entry's Phone Number:");
		String pn = myS.nextLine();
		
		// return values
		return getDirectory().LinearSearchByPhoneNumber(pn);		
	}

	// search by binary method
	public PhoneBookEntry SearchbyIdBinarySearch() {
		
		// prompt for parameter
		System.out.println("Enter Entry's ID:");
		int id = myS.nextInt();
		
		// return values
		return getDirectory().SearchbyIdBinarySearch(id);		
	}

	// sort dir method
	public void sortDir() {
		getDirectory().sortDir();
		getDirectory().printDirectory();
	}

	// print admin info
	public void PrintUserInfo() {
		try {
	        // read in info 
			BufferedReader reader = new BufferedReader(new FileReader("AdminInfo.txt"));
	        String line = reader.readLine();
	       	        
	        while (line != null) {
	        	System.out.println(line);
	        	line = reader.readLine();
	         }
	         
	         reader.close();

	         
	    } catch (IOException e) {
	         e.printStackTrace();
	    }
	}
	
	// change pass method
	public void changePassword() {
		// prompt for new pass
		System.out.println("Enter new Password:");
		String newPass = myS.nextLine();
		
		try {
	        // read in info 
			BufferedReader reader = new BufferedReader(new FileReader("AdminInfo.txt"));
	        String line = reader.readLine();
	        StringBuilder sb = new StringBuilder();
	        
	        while (line != null) {
	        	// split with each comma
	        	String[] parts = line.split(",");
	            String username = parts[0];
	        	String email = parts[2];
	        	// new line
	            sb.append(username).append(",").append(newPass).append(",").append(email).append("\n");
	            line = reader.readLine();
	         }
	         
	         reader.close();
	         
	         // write out the updated file
	         BufferedWriter writer = new BufferedWriter(new FileWriter("AdminInfo.txt"));
	         writer.write(sb.toString());
	         writer.close();
	         
	    } catch (IOException e) {
	         e.printStackTrace();
	    }
	}

	// change user method
	public void changeUsername() {
		// prompt for new user
		System.out.println("Enter new Password:");
		String newUser = myS.nextLine();
		
		try {
	        // read in info 
			BufferedReader reader = new BufferedReader(new FileReader("AdminInfo.txt"));
	        String line = reader.readLine();
	        StringBuilder sb = new StringBuilder();
	        
	        while (line != null) {
	        	// split with each comma
	        	String[] parts = line.split(",");
	        	String password = parts[1];
	        	String email = parts[2];
	        	// new line
	            sb.append(newUser).append(",").append(password).append(",").append(email).append("\n");
	            line = reader.readLine();
	         }
	         
	         reader.close();
	         
	         // write out the updated file
	         BufferedWriter writer = new BufferedWriter(new FileWriter("AdminInfo.txt"));
	         writer.write(sb.toString());
	         writer.close();
	         
	    } catch (IOException e) {
	         e.printStackTrace();
	    }
	}
	
}
