package MobilePhone;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone("04xxxxxxxx");
	
	
	public static void main(String[] args) {
		boolean quit = false;
		startPhone();
		printActions();
		while(!quit) {
			System.out.println("\nEnter action: (6 to show available actions)");
			int action = scanner.nextInt();
			scanner.nextLine();
			switch(action) {
			case 0:
				System.out.println("\nShutting down....");
				quit = true;
				break;
			
			case 1:
				printContacts();
				break;
			case 2:
				addNewContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6:
				printActions();
				break;
			}
			
		}
		

	}
	private static void removeContact() {
		System.out.println("Enter existing contact name: ");
		String name = scanner.nextLine();
		Contact existingContact = mobilePhone.queryContact(name);
		if(existingContact == null)
		{
			System.out.println("Contact does not exist");
			return;
		}
		if(mobilePhone.removeContact(existingContact))
		{
			System.out.println("Successfully deleted the contact");
		}
		else
		{
			System.out.println("Error deleting contact");
		}		
	}
	private static void queryContact() {
		System.out.println("Enter existing contact name: ");
		String name = scanner.nextLine();
		Contact existingContact = mobilePhone.queryContact(name);
		if(existingContact == null)
		{
			System.out.println("Contact does not exist");
			return;
		}
		System.out.println("Name: "+existingContact.getName()+", phone number: "+existingContact.getPhoneNumber());
				
	}
	private static void updateContact() {
		System.out.println("Enter existing contact name: ");
		String name = scanner.nextLine();
		Contact existingContact = mobilePhone.queryContact(name);
		if(existingContact == null)
		{
			System.out.println("Contact does not exist");
			return;
		}
		System.out.println("Enter new contact name: ");
		String newName = scanner.nextLine();
		System.out.println("Enter new contact phone number: ");
		String newNumber = scanner.nextLine();
		Contact newContact = Contact.createContact(newName, newNumber);
		if(mobilePhone.updateContact(existingContact, newContact))
		{
			System.out.println("Successfully updated the contact");
		}
		else
		{
			System.out.println("Error updating record");
		}
	}
	private static void addNewContact() {
		System.out.println("Enter new contact name: ");
		String name = scanner.nextLine();
		System.out.println("Enter new contact phone number: ");
		String number = scanner.nextLine();
		Contact newContact = Contact.createContact(name, number);
		if(mobilePhone.addNewContect(newContact))
		{
			System.out.println("New Contact added: name = "+ name+", phone number: "+number);
		}
		else
		{
			System.out.println(name+" already exist");
		}
		
	}
	private static void printContacts() {
		mobilePhone.printContacts();
		
	}
	private static void startPhone() {
		System.out.println("Phone Started");
	}
	
	private static void printActions() {
		System.out.println("\nAvailable actions:\npress");
		System.out.println("0 - to Shutdown\n"+
						   "1 - to print contacts\n"+
						   "2 - to add a new contact\n"+
						   "3 - to update an existing contact\n"+
						   "4 - to remove an existing contact\n"+
						   "5 - query if an contact exist\n"+
						   "6 - to print a list of available actions.");
		System.out.println("Choose your action: ");
		
	}

}
