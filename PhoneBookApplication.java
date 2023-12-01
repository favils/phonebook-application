package Homework7;
import java.io.*;
import java.util.Scanner;

public class PhoneBookApplication {
	public static void main (String args[]) throws Exception {
		
		// login
		Scanner login = new Scanner(System.in);
		System.out.println("Welcome.  Please login.");
		System.out.println("Enter user:");
		String userinput = login.nextLine();
		System.out.println("Enter pass:");
		String passinput = login.nextLine();
	
		// create an object of type PhoneBookDirectory 
		PhoneBookDirectory aDir = new PhoneBookDirectory();
		
		// declare var
		String user="";
		String pass="";
		String email="";
		
		// read in info for PhoneBookAdmin
		try {
	        // read in info 
			File AdminInfo = new File("AdminInfo.txt");
			BufferedReader reader = new BufferedReader(new FileReader(AdminInfo));
	        String line = reader.readLine();      	
	        while (line != null) {
	        	// split with each comma
	        	String[] parts = line.split(",");
	            user = parts[0];
	        	pass = parts[1];
	        	email = parts[2];
	        	line = reader.readLine();
	         }
	         reader.close();
	    } catch (IOException e) {
	         e.printStackTrace();
	    }
		
		// create an object of type PhoneBookAdmin from file info
		PhoneBookAdmin admin = new PhoneBookAdmin(user,pass,email,aDir);
		
		// create an object of type PhoneBookDirectory 
		PhoneBookDirectory nDir = new PhoneBookDirectory();
		
		// declare & initialize var
		int nID = 0;
		String nUser ="";
		String nPass = "";
		
		// read in info for PhoneBookAdmin
		try {
			// read in info 
			BufferedReader reader = new BufferedReader(new FileReader("NormalInfo.txt"));
			String line = reader.readLine();      	
			while (line != null) {
			// split with each comma
				String[] parts = line.split(",");
				String id = parts[0];
				nID = Integer.parseInt(id);
				nUser = parts[1];
				nPass = parts[2];
				line = reader.readLine();
			}
			         
			reader.close();
			         
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// create an object of type PhoneBookAdmin from file info
		NormalUser normalUser = new NormalUser(nID,nUser,nPass,nDir);
		
		// make attempts
		int attempts = 0;
		
		// while loop to run admin or normal or keep asking for user/pass
		while (attempts < 3)	{
			if (userinput.equals(user)&& passinput.equals(pass)) {
				admin.runAdmin();
				return;
			} else if (userinput.equals(nUser)&& passinput.equals(nPass)) {
				normalUser.runUser();
				return;
			} else {
				System.out.println("Wrong username or password.  Please try again.");
				System.out.println("Enter user:");
				userinput = login.nextLine();
				System.out.println("Enter pass:");
				passinput = login.nextLine();
			}
		}
		
		// if we get here, exceeded attempts
		System.out.println("You have exceeded the number of attempts.");
		
		login.close();
	}
}
	
