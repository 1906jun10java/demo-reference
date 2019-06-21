package com.revature.datastructures;

public class MyBinaryTreeDemo {

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree();
		System.out.println("is the tree empty? "+tree.isEmpty());
		System.out.println("size of tree: "+tree.getSize());
		tree.add(8);
		tree.add(87);
		tree.add(4);
		tree.add(2);
		tree.add(17);
		System.out.println("after adding some values...");
		System.out.println("is the tree empty? "+tree.isEmpty());
		System.out.println("size of tree: "+tree.getSize());
	}

}
