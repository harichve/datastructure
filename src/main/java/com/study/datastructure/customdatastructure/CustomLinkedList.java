package com.study.datastructure.customdatastructure;

/**
 * The Class CustomLinkedList.
 * A doubly linked list which is used to store a list of values which are linked in a linear way. 
 */
public class CustomLinkedList {

	/** The value which is used to store the numeric value in every node of the list. */
	public int value;
	
	/** The previous which is a reference to navigate to the previous node. */
	public CustomLinkedList previous;
	
	/** The next which is a reference to navigate to the next node. */
	public CustomLinkedList next;
	
	/**
	 * insertAtStart method is used to insert value at the starting of the List.
	 *
	 * @param head the CustomLinkedList.
	 * @param value the key value.
	 * @return starting node of the CustomLinkedList
	 */
	public CustomLinkedList insertAtStart(CustomLinkedList head, int value) {
		CustomLinkedList node = new CustomLinkedList();
		node.value = value;
		node.next = head;
		node.previous = null;
		head = node;
		return head;
	}
	
	/**
	 * insertAtEnd method is used to insert the value at the end of the list.
	 *
	 * @param starting node of the CustomLinkedList
	 * @param value to be inserted
	 * @return updated CustomLinkedList
	 */
	public CustomLinkedList insertAtEnd(CustomLinkedList head, int value) {
		CustomLinkedList node = new CustomLinkedList();
		CustomLinkedList lastNode = new CustomLinkedList();
		lastNode.value = value;
		lastNode.next = null;
		node = head;
		if(head != null) {
			while(node.next != null) {
				node=node.next;
			}
			node.next = lastNode;
			lastNode.previous = node;
		}else {
			node.next = null;
		}
		return head;
	}
	
	/**
	 * insertAtPosition method is used to insert the value at the mentioned position.
	 *
	 * @param starting node of the CustomLinkedList
	 * @param position in the list
	 * @param value to be inserted
	 * @return updated CustomLinkedList
	 */
	public CustomLinkedList insertAtPosition(CustomLinkedList head, int position, int value) {
		int currentPosition;
		CustomLinkedList node = new CustomLinkedList();
		node = head;
		CustomLinkedList nthNode = new CustomLinkedList();
		nthNode.value = value;
		if(node!=null) {
			if(position == 1) {
				nthNode.previous = null;
				nthNode.next = head;
				head = nthNode;
			}else {
				for(currentPosition=1; currentPosition<position-1; currentPosition++) {
					if(node==null) {
						System.out.println("Position exceeds list size!");
						break;
					}
					node = node.next;
				}
				nthNode.next = node.next;
				nthNode.previous = node;
				node.next = nthNode;
			}
		}else {
			if(position == 1) {
				nthNode.previous = null;
				nthNode.next =null;
				head = nthNode;
			}else {
				System.out.println("List is Empty!");
			}
		}
		return head;
	}
	
	/**
	 * Delete method is used to delete the value at the start of the list. 
	 *
	 * @param starting node of the CustomLinkedList
	 * @return updated CustomLinkedList
	 */
	public CustomLinkedList deleteAtStart(CustomLinkedList head) {
		if(head!=null) {
			if(head.next!=null) {
				head = head.next;
				head.previous = null;
				return head;
			}else {
				System.out.println("List is emptied");
				return null;
			}
		}
		System.out.println("List is empty");
		return null;
	}
	
	/**
	 * deleteAtEnd method is used to delete the value at the end of the list.
	 *
	 * @param starting node of the CustomLinkedList
	 * @return updated CustomLinkedList
	 */
	public CustomLinkedList deleteAtEnd(CustomLinkedList head) {
		CustomLinkedList node = new CustomLinkedList();
		node = head;
		if(node != null) {
			if(node.next==null) {
				System.out.println("List is emptied");
				return null;
			}else {
				while(node.next.next != null) {
					node=node.next;
				}
				node.next = null;
			}
			return head;
		}else {
			System.out.println("List is empty");
			return null;
		}
	}
	
	/**
	 * deleteAtPosition method is used to delete the value at the mentioned position.
	 *
	 * @param starting node of the CustomLinkedList
	 * @param position in the list
	 * @return updated CustomLinkedList
	 */
	public CustomLinkedList deleteAtPosition(CustomLinkedList head, int position) {
		int currentPosition;
		CustomLinkedList node = new CustomLinkedList();
		node = head;
		if(node!=null) {
			if(position == 1) {
				head = head.next;
				head.previous = null;
			}else {
				for(currentPosition=1; currentPosition<position-1; currentPosition++) {
					if(node==null) {
						System.out.println("Position exceeds list size!");
						break;
					}
					node = node.next;
				}
				node.next = node.next.next;
				node = node.next;
				node.previous = node.previous.previous;
			}
		}else {
				System.out.println("List is Empty!");
		}
		return head;
	}
	
	/**
	 * contains method is used to find whether the key value is present in the list of values.
	 *
	 * @param starting node of the CustomLinkedList
	 * @param key value to be searched
	 * @return true, if present
	 */
	public boolean contains(CustomLinkedList node, int value) {
		if(node == null) {
			return false;
		}
		while(node.next!=null) {
			if(node.value == value) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	/**
	 * sizeOf method is used to get the size of the list.
	 *
	 * @param starting node of the CustomLinkedList
	 * @return size of the list
	 */
	public long sizeOf(CustomLinkedList node) {
		int size = 0;
		while(node.next!=null) {
			size++;
		}
		return size;
	}
	
	/**
	 * positionOf method is used to get the position of the key value present in the list.
	 *
	 * @param node the CustomLinkedList
	 * @param value the key value to be searched
	 * @return the position of the key value in the list
	 */
	public long positionOf(CustomLinkedList node,int value) {
		int size = 0;
		while(node.next!=null) {
			size++;
			if(node.value == value) {
				return size;
			}
		}
		return -1L;
	}
	
	/**
	 * getValueAt method is used to get the value present at the mentioned position.
	 *
	 * @param starting node of the CustomLinkedList
	 * @param position in the list
	 * @return CustomLinkedList node at mentioned position.
	 */
	public CustomLinkedList getValueAt(CustomLinkedList node,int position) {
		int curretPosition=1;
		if(node!=null) {
			while(node.next!=null) {
				if(curretPosition==position) {
					return node;
				}
				curretPosition++;
				node=node.next;
			}
		}
		System.out.println("Position exceeds list size!");
		return null;
	}
	
	
}
