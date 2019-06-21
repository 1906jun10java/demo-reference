package com.revature.datastructures;

public class MyLinkedList<T> {

	public MyLinkedList() {
	}

	// root node of the list, the 'head'
	private Node<T> head; // instance variable, which gets initialized to the default value for its
							// datatype (here: null)

	// end node of the list, the 'tail'
	private Node<T> tail;

	// insert a node at the end of the list
	public void insert(T data) {

		// create a new Node for the data
		Node<T> newNode = new Node<>(null, data);

		// if the head is null, this new node will become the head
		if (this.head == null) {
			System.out.println("List is empty, adding first element");
			this.head = newNode;
			this.tail = newNode;
		}
		// otherwise, we add this as the tail
		else {
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}

	}

	// remove and return the first item in the list
	public T poll() {
		Node<T> firstNode = this.head;
		if (firstNode != null) {
			this.head = firstNode.getNextNode();
			return firstNode.getData();
		}
		return null;
	}

	// return but do not remove the first item
	public T peek() {
		if (this.head != null) {
			return this.head.getData();
		}
		return null;
	}

	// remove first node whose data matches provided key
	public boolean removeByKey(T key) {

		if (key == null) {
			return false;
		}

		// create a reference to current node
		Node<T> currentNode = this.head;

		// create a reference to the next node (after the current)
		Node<T> nextNode = currentNode.getNextNode();

		// if first node matches the key, move head to next node
		if (currentNode != null && currentNode.getData() != null && currentNode.getData().equals(key)) {
			this.head = nextNode;
			return true;
		}

		// iterate through list while currentNode != null
		while (currentNode != null) {

			// if nextNode is not null and matches the key
			// point currentNode to the node after nextNode and return true
			if (nextNode != null && nextNode.getData().equals(key)) {
				currentNode.setNextNode(nextNode.getNextNode());
				return true;
			}

			// advance currentNode to the next node in the list
			currentNode = currentNode.getNextNode();

			// if nextNode is not null, advance next node to the one after it
			if (nextNode != null) {
				nextNode = nextNode.getNextNode();
			}

		}

		return false;
	}

	// convenience method for printing the list
	public void printList() {
		Node<T> currentNode = this.head;
		while (currentNode != null) {
			System.out.println("Node location: " + currentNode.hashCode() + ", Node value: " + currentNode.getData());
			currentNode = currentNode.getNextNode();
		}
	}

	// remove all duplicate from list
	public void removeDuplicates() {
		Node<T> currentNode = this.head;
		Node<T> tempNode;
		T currentValue = null;

		// System.out.println(tempNode); does not compile because variables in method
		// and block/local scope do NOT receive default values the way the instance and
		// static variables do.

		// do we have a list in the first place?
		if (currentNode != null) {
			currentValue = currentNode.getData();
			System.out.println("at beginning of list, initial value = " + currentValue);

			do {
				System.out.println("beginning outer loop iteration");
				tempNode = currentNode; // have "runner" start in the same spot as the current node
				// don't need to re-check earlier nodes in the list

				while (tempNode != null && tempNode.getNextNode() != null) {
					// check for matches
					T nextValue = tempNode.getNextNode().getData();
					System.out.println("comparing values ("+currentValue+" , "+nextValue+")");
					if (currentValue.equals(nextValue)) {
						System.out.println("removing first instance of the value: "+currentValue);
						this.removeByKey(currentValue);
					}
					System.out.println("moving tempNode to next node");
					tempNode = tempNode.getNextNode();
				}

				System.out.println("moving to currentNode to next node");
				if (currentNode.getNextNode() != null) {
					System.out.println("no more duplicates of " + currentValue + " left");
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					this.printList();
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					currentValue = currentNode.getNextNode().getData();
					currentNode = currentNode.getNextNode();
				}

			} while (currentValue != null && currentNode.getNextNode() != null);
			// exit iteration if current node's value is null OR there is no next node
			// note: a refinement would be to scrub out or skip all nodes with null values
			// instead of quitting as soon as we find one
		}
	}
}
