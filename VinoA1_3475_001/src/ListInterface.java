public interface ListInterface<T> {

	/**
	 * Adds a new item to the end of the list.
	 * @param newEntry	New item to be added.
	 */
	public void add(T newEntry);
	
	/**
	 * Adds a new item at a specific position in the list.
	 * @param newPosition	Integer that specifies a position in the list.
	 * @param newEntry		New item to be added.
	 */
	public void add(int newPosition, T newEntry);

	/**
	 * Removes an item at a specific position in the list.
	 * @param givenPosition		The position in the list where an element will be removed.
	 * @return
	 */
	public T remove(int givenPosition);
	
	/**
	 * Removes all items in the list
	 */
	public void clear();
	
	/**
	 * Replaces an item at a specific position in the list with a new item
	 * @param givenPosition		The integer that specifies the position of the new item
	 * @param newEntry			The new item to be added as a replacement.
	 * @return					Returns the replaced item.
	 */
	public T replace(int givenPosition, T newEntry);
	  
	/**
	 * 
	 * @param givenPosition		Position of the item to be referenced.
	 * @return					Reference to the original item.
	 */
	public T getEntry(int givenPosition);
	
	/**
	 * Gets all items adhering to the list order.
	 * @return	An array of the list items.
	 */
	public T[] toArray();
	
	/**
	 * Checks if a specific item is in the list.
	 * @param anEntry	The item that is being checked for.
	 * @return			True or false depending on whether or not that item exists.
	 */
	public boolean contains(T anEntry);
	
	/**
	 * Gets the length of the list.
	 * @return	Integer of the number of items in the list.
	 */
	public int getLength();
	
	
	/**
	 * Checks if list is empty.
	 * @return	If the list is empty, return True. Else, false.
	 */
	public boolean isEmpty();	
	  
   
   
}

