package sen2212;


//Java program to implement
//a Singly Linked List
public class LinkedList {

	Node head; // head of list

	// Linked list Node.
	// This inner class is made static
	// so that main() can access it
	

	// Method to insert a new node
	public static LinkedList insert(LinkedList list, String data)
	{
		// Create a new node with given data
		Node new_node = new Node(data);
		new_node.next = null;

		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		}
		else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}

	// Method to print the LinkedList.
	public static String printList(LinkedList list)
	{
		String str="";
		
		Node currNode = list.head;
	
		System.out.print("LinkedList: ");
	
		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			//System.out.print(currNode.data + " ");
			str=str+currNode.data+"\n ";
			// Go to next node
			currNode = currNode.next;
		}
		//System.out.println(str);
		return str;
		
	}
	public static String lastIndex(LinkedList list) {
		
		if(list.head!=null) {
			Node last = list.head;
			while (last.next != null) {
				
				last=last.next;
			}
			return last.data;
		}
		
		return 0+"";
		
	}
	
}

