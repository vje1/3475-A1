import java.util.Scanner;

public class SocialMediaApp {
	
	private static LinkedList<Person> userList = new LinkedList<>();
	
	public static Scanner scan = new Scanner(System.in);

	public static void print(String string) {
		System.out.println(string);
	}
	
	public static void displayMenu() {
		print("Select an option:\nEnter\t1 to add a person\n"
				+ "\t2 to add a person at a specific position\n"
				+ "\t3 to remove a person\n"
				+ "\t4 to remove all persons\n"
				+ "\t5 to display all persons\n"
				+ "\t6 to search a person\n"
				+ "\t7 to add/remove from a person's friends list\n"
				+ "\t8 to count the total number of persons\n"
				+ "\t9 to check if the list is empty\n"
				+ "\t10 to exit the app\n");
	}
	
	
	public static void addPerson() {
		print("Please enter the new person's name: ");
		String name = scan.nextLine();
		print("Please enter the email: ");
		String email = scan.nextLine();
		print("Please enter the location: ");
		String location = scan.nextLine();
		
		Person newPerson = new Person(name, email, location);
		userList.add(newPerson);
		print(newPerson.getName() + " has been added.");
	}
	
	public static void addPersonAt() {
        System.out.print("Enter position to add (1-" + (userList.getLength()) + "): ");
        int position = scan.nextInt();
        scan.nextLine();
        //check position validity first
        if (position < 0 || position > userList.getLength()) {
            System.out.println("Invalid position.");
            return;
        }
		print("Please enter the new person's name: ");
		String name = scan.nextLine();
		print("Please enter the email: ");
		String email = scan.nextLine();
		print("Please enter the location: ");
		String location = scan.nextLine();
		
		Person newPerson = new Person(name, email, location);
		userList.add(position, newPerson);
        print(newPerson.getName() + " added at position " + position);
	}
	
	public static void removePerson() {
		displayAll();
		print("\nPlease enter the number of who you want to remove (1-" + (userList.getLength()) + "): ");
        int position = scan.nextInt();
		if (position < 0 || position > userList.getLength()) {
            System.out.println("Invalid index.");
            return;
        } else {
        	Person personToRemove = userList.remove(position);
        	System.out.println("Removed " + personToRemove.getName() + ".");
        }


	}
	
	
	public static void clear() {
		userList.clear();
		print("\nAll users have been removed.");
	}
	
	public static void displayAll() {
		print("Full user list:\n");
		for(int i = 1; i <= userList.getLength(); i++) {
			print(i + ". " + userList.getEntry(i).getName());
		}
	}
	
	public static void search() {
		print("Enter the name or email of the person you wish to search for: ");
		String query = scan.nextLine();
		for(Person user : userList.toArray()) {
			if(user.getName().equals(query) || user.getEmail().equals(query)) {
				print("Search result:\n");
				print("Name: " + user.getName() + "\nEmail: " + user.getEmail() + "\nLocation: " + user.getLocation() + "\nFriends:\n");
				for(Person friend : user.getFriends().toArray()) {
					print(friend.getName());
				}
				print("\n");
				return;
			} 
		}
		print("Person not found.");
	}
	
	private static Person findPerson(String search) {
	    for (Person person : userList.toArray()) {
	        if (person.getName().equals(search) || person.getEmail().equals(search)) {
	            return person;
	        }
	    }
	    return null; // Person not found
	}
	
	public static void editFriends() {
		boolean found = false;
		Person selectedUser = null;
		print("Enter the name or email of the person you wish to edit friends for: ");
		String query = scan.nextLine();
		for(Person user : userList.toArray()) {
			if(user.getName().equals(query) || user.getEmail().equals(query)) {
				found = true;
				selectedUser = user;
				print("Found " + user.getName());
				print("Friends:\n");
				for(Person friend : user.getFriends().toArray()) {
					print(friend.getName() + "\n");
				}
			} 
		}
		if(!found) {
			print("Person could not be found.\n");
			return;
		}

		boolean valid = false;
		while(!valid) {
			print("\nWould you like to [a]dd or [r]emove a friend? Please input the appropriate letter.\n");
			String option = scan.nextLine();
			if(option.equals("a") || option.equals("A")) {
				print("Please enter the name or email of the friend to be added: ");
				String friendQuery = scan.nextLine();
				Person newFriend = findPerson(friendQuery);
				if(newFriend == null) {
					print("Person could not be found.");
				} else {
					selectedUser.addFriend(newFriend);
					print(newFriend.getName() + " has been added to " + selectedUser.getName() + "'s friendslist.");
					break;
				}
			} else if(option.equals("r") || option.equals("R")) {
				print("Enter the name or email of the friend to be removed: ");
				String friendQuery = scan.nextLine();
				Person friendToRemove = findPerson(friendQuery);
				if(friendToRemove == null) {
					print("Person could not be found.");
				} else {
					selectedUser.removeFriend(friendToRemove);
					print(friendToRemove.getName() + " has been removed from " + selectedUser.getName() + "'s friendslist.");
					break;
				}
			} else {
				print("Please enter a valid option.\n");
			}
		}

	}
	
	public static void countUsers() {
		int numOfUsers = userList.getLength();
		print("There are " + Integer.toString(numOfUsers) + " total users/persons.");
		
	}
	
	public static void checkEmpty() {
		if(userList.isEmpty()) {
			print("userList is empty.");
		} else 
			print("userList is not empty.");
	}
	
	public static void exit() {
		print("Thank you for coming. Have a nice day.");
	}
	
	public static void main(String[] args) {
		
		System.out.println("Program start!\n\n");
		
		while(true) {
			displayMenu();
			int menuOption = scan.nextInt();
			scan.nextLine();
			
			switch(menuOption) {
			case 1:
				addPerson();
				break;
			case 2:
				addPersonAt();
				break;
			case 3:
				removePerson();
				break;
			case 4:
				clear();
				break;
			case 5:
				displayAll();
				break;
			case 6:
				search();
				break;
			case 7:
				editFriends();
				break;
			case 8:
				countUsers();
				break;
			case 9:
				checkEmpty();
				break;
			case 10:
				exit();
				break;
			default:
				print("That was not an option. Please try again.");
			}
			if (menuOption == 10) {
				break;
			}
		}
	
		
		
	}

}
