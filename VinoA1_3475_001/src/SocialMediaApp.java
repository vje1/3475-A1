
public class SocialMediaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test
		System.out.println("Creating empty Integer list testList");
		ListInterface<Integer> testList = new LinkedList<Integer>();
		
		if(testList.isEmpty()) {
			System.out.println("The list is currently empty.\n");
			
		}
		
		System.out.println("Adding new items.\n");
		testList.add(5);
		testList.add(10);
		testList.add(15);
		testList.add(20);
		
		//display all items in Linked List
		for(int i = 1; i <= testList.getLength(); i++) {
			System.out.println(testList.getEntry(i));
		}
		
	}

}
