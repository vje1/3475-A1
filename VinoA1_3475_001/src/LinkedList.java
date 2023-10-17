
public class LinkedList<T> implements ListInterface<T> {

	private Node firstNode;
	private int entries;
	
	//constructor
	public LinkedList() {
		initialize();
	}
	
	public void initialize() {
		firstNode = null;
		entries = 0;
	}
	
	private Node getNodeAt(int givenPosition) {
		Node currentNode = firstNode;
		
		for(int i = 1; i < givenPosition; i++) {
			currentNode = currentNode.getNextNode();
			
		}
		
		return currentNode;
	}
	
	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry);
		if(isEmpty()) {
			firstNode = newNode;
		} else {
			Node lastNode = getNodeAt(entries);
			lastNode.setNextNode(newNode); //the last node points to the new node
		}
		
		entries++;

	}

	@Override
	public void add(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		if((givenPosition >= 1) && (givenPosition <= entries + 1)) {
			Node newNode = new Node(newEntry);
			if(givenPosition == 1) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else {
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			entries++;
		} else {
			throw new IndexOutOfBoundsException("Cannot operate on that position.");
		}
		
	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		T result = null;
		if((givenPosition >= 1) && (givenPosition <= entries)) {
			if(givenPosition == 1) {
				result = firstNode.getItem();
				firstNode = firstNode.getNextNode();
			} else {
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				result = nodeToRemove.getItem();
				nodeBefore.setNextNode(nodeToRemove.getNextNode());
			}
			entries--;
			return result;
		}
		else {
			throw new IndexOutOfBoundsException("Invalid index given.");
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		initialize();
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		if((givenPosition >= 1) && (givenPosition <= entries)) {
			Node nodeToReplace = getNodeAt(givenPosition);
			T itemBeforeReplace = nodeToReplace.getItem();
			nodeToReplace.setItem(newEntry);
			return itemBeforeReplace; //returning the original data
		} else {
			throw new IndexOutOfBoundsException("Invalid index given");
		}

	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		if ((givenPosition >= 1) && (givenPosition <= entries)) {
			return getNodeAt(givenPosition).getItem();
		} else
			throw new IndexOutOfBoundsException("Invalid index given.");
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		T[] array = (T[])new Object[entries];
		
		int i = 0;
		Node currentNode = firstNode;
		
		while ((i < entries) && (currentNode != null)) {
			array[i] = currentNode.getItem();
			currentNode = currentNode.getNextNode();
			i++;
		}
		return array;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		boolean contains = false;
		Node currentNode = firstNode;
		while (!contains && (currentNode != null)) {
			if (anEntry.equals(currentNode.getItem())) {
				contains = true;
				break;
			} else {
				currentNode = currentNode.getNextNode();
			} ///loop
		}
		
		return contains;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return entries;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		boolean isEmpty = true;
		
		if(entries == 0) {
			return isEmpty;
		} else
		return false;
	}
	
	private class Node {
		private T item;
		private Node next;
		
		//constructor:
		private Node (T data) {
			item = data;
			next = null;
		}
		
		//node const. with next node:
		private Node (T data, Node nextNode) {
			item = data;
			next = nextNode;
		}
		
		private T getItem() {
			return item;
		}
		
		private void setItem (T newItem) {
			item = newItem;
		}
		
		private Node getNextNode() {
			return next;
		}
		
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
	}

}
