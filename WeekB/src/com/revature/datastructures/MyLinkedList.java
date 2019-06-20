package com.revature.datastructures;

public class MyLinkedList<T> {

	public MyLinkedList() {
	}

	// root node of the list, the 'head'
	private Node<T> head;

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
		return null;
	}

	// return but do not remove the first item
	public T peek() {
		return null;
	}

	// remove first node whose data matches provided key
	public boolean removeByKey(T key) {
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

}
