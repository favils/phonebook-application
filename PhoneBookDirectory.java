package Homework7;
import java.util.*;

public class PhoneBookDirectory {
	// declare priv var
	private PhoneBookEntry[] directory;
	private int size;
	
	// default constructor
	public PhoneBookDirectory() {
		directory = new PhoneBookEntry[6];
		size = 0;
			
	}
	
	// add entry in first empty space
	public int addEntry(PhoneBookEntry entry) {
	    // check if array is full
	    if (size == 6) {
	        return 0;
	    }

	    // find the first empty space & add  entry
	    for (int i = 0; i < size; i++) {
	        if (directory[i] == null) {
	            directory[i] = entry;
	            size++;
	            return 1;
	        }
	    }
	    
	    // if we get here, array has no empty slot
	    directory[size] = entry;
        size++;
        return 1;
	}
	
	// prints all entries
	public void printDirectory() {
		System.out.println("Here are all the current entries:");
		for (int i=0; i < size; i++) {
	    	System.out.println(i + ". ");
	    	directory[i].printBookEntry();
		}
	}
	
	// search by number returns 0 or 1
	public int LinearSearchByPhoneNumber(String PhoneNumber) {
		for (int i=0; i < size; i++) {
			if (directory[i].getPhoneNumber().equals(PhoneNumber)) {
				return 1;
			}
		}
		return 0;
	}
	
	// sort directory
	public void sortDir() {
		for (int i =0; i < size; i++) {
			for (int j=i+1; j < size; j++) {
				if (directory[i].getId() > directory[j].getId()) {
					PhoneBookEntry temp = directory[i];
					directory[i] = directory[j];
					directory[j] = temp;
				}
			}
		}
	}
	
	// search by id using binary search
	public PhoneBookEntry SearchbyIdBinarySearch(int id) {
		sortDir();
		int low = 0;
		int high = 5;
		while (high>=low) {
			int mid = (low+high)/2;
			if(id < directory[mid].getId()) {
				high = mid -1;
			} else if (id == directory[mid].getId()) {
				return new PhoneBookEntry(directory[mid].getId(), directory[mid].getFirstName(), directory[mid].getLastName(), 
						directory[mid].getEmail(), directory[mid].getZipCode(), directory[mid].getPhoneNumber());
			} else {
				low = mid + 1;
			}
			
		}
		// if not found then return 0
		return null;
	}
	
	// menu for edit method
	public void editmenu() {
		System.out.println("Enter int of what you want to edit:");
		System.out.println("1. ID");
		System.out.println("2. First Name");
		System.out.println("3. Last Name");
		System.out.println("4. Email");
		System.out.println("5. Zip Code");
		System.out.println("6. Phone Number");
	}
	
	// edit method using name attributes
	public int Edit(String firstName, String lastName) {
		Scanner input = new Scanner(System.in);
		for (int i =0; i < size; i++) {
			if (firstName.equalsIgnoreCase(directory[i].getFirstName()) && lastName.equalsIgnoreCase(directory[i].getLastName())) {
				editmenu();
				int choice = input.nextInt();
				// change attribute depending on user choice
				if (choice == 1) {
					System.out.println("Enter new ID:");
					int newID = input.nextInt();
					directory[i].setId(newID);
				} else if (choice == 2) {
					System.out.println("Enter new first name:");
					String newF = input.nextLine();
					directory[i].setFirstName(newF);
				} else if (choice == 3) {
					System.out.println("Enter new last name:");
					String newL = input.nextLine();
					directory[i].setLastName(newL);
				} else if (choice == 4) {
					System.out.println("Enter new email:");
					String newEmail = input.nextLine();
					directory[i].setFirstName(newEmail);
				} else if (choice == 5) {
					System.out.println("Enter new zip code:");
					String newZC = input.nextLine();
					directory[i].setFirstName(newZC);
				} else if (choice == 6) {
					System.out.println("Enter new phone number:");
					String newNum = input.nextLine();
					directory[i].setFirstName(newNum);
				}
				input.close();
				return 1;
			}
		}
		return 0;
	}

	// delete entry
	public int DeleteEntry(int id) {
		for (int i = 0; i < size; i++) {
	    	if (directory[i].getId() == id) {
	    		// set to null
	            directory[i] = null;
	            return 1;
	        }
	    }
		return 0;
	}
}

