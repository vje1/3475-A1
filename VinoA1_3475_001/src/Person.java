
class Person {
    private String name;
    private String email;
    private String location;
    private LinkedList<Person> friends;

    //constructor
    public Person(String name, String email, String location, LinkedList<Person> friends) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.friends = new LinkedList<>();
    }

    public Person(String name, String email, String location) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.friends = new LinkedList<>();
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public LinkedList<Person> getFriends() {
        return friends;
    }

    public void addFriend(Person friend) {
        friends.add(friend);
    }
    
    public void removeFriend(Person friend) {
    	int removePosition = -1; //May need to switch the value to -1
    	for(int i = 1; i <= friends.getLength(); i++) { //debug
    		Person friendCompare = friends.getEntry(i);
    		if(friendCompare.getName().equals(friend.getName())) {
    			removePosition = i;
    			break;
    		}
    	}
    	if(removePosition != -1) {
    		friends.remove(removePosition);
    	}
    	
    }
    
}