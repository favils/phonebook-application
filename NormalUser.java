package Homework7;
import java.io.*;
import java.util.*;

interface normal {
	public int addEntry();
	public int Edit();
	public int LinearSearchByPhoneNumber();
	public void sortDir();
	public void PrintUserInfo();
}

public class NormalUser extends User implements normal {
	// has an id(int), username, password and PhoneBookDirectory
	private int id;
	private String user;
	private String pass;
	private PhoneBookDirectory dir;
	private Scanner myS;
	
	// constructor that calls super class
	public NormalUser(int id, String user, String pass, PhoneBookDirectory dir) {
		super(user,pass,dir);
		this.id = id;
		myS = new Scanner (System.in);
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
			
		// prompts for parameter in edit method
		System.out.println("Enter first name:");
		String fname = myS.nextLine();
		System.out.println("Enter last name:");
		String lname = myS.nextLine();
		
		// return values
		return getDirectory().Edit(fname, lname);
	}

	// linear search method
	public int LinearSearchByPhoneNumber() {
		
		// prompt for parameter
		System.out.println("Enter Entry's Phone Number:");
		String pn = myS.nextLine();
		
		// return values
		return getDirectory().LinearSearchByPhoneNumber(pn);		
	}

	// sort directory method
	public void sortDir() {
		getDirectory().sortDir();
		getDirectory().printDirectory();
	}
	
	// print normal user info
	public void PrintUserInfo() {
		try {
	        // read in info 
			BufferedReader reader = new BufferedReader(new FileReader("NormalInfo.txt"));
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

	// run normal user acc
	public void runUser() {
		int choice = -1;
        while (choice != 0) {
            System.out.println("Choose an option:");
            System.out.println("1. Add an entry");
            System.out.println("2. Edit an entry");
            System.out.println("3. Search for an entry using Linear Search by Phone Number");
            System.out.println("4. Sort Directory");
            System.out.println("5. Print User Info");
            System.out.println("0. Quit");

            choice = myS.nextInt();
            myS.nextLine();

            switch (choice) {
                case 1:
                    addEntry();
                    break;
                case 2:
                    Edit();
                    break;
                case 3:
                	LinearSearchByPhoneNumber();
                case 4:
                	sortDir();
                    break;
                case 5:
                	PrintUserInfo();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
	}
}
