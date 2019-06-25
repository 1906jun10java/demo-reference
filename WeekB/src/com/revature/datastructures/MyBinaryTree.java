package com.revature.datastructures;

public class MyBinaryTree {

	private TreeNode root;

	// add a new value to the tree
	public void add(int value) {
		root = addRecursive(root, value);
	}

	private TreeNode addRecursive(TreeNode current, int value) {
		// base case
		if (current == null) {
			return new TreeNode(value);
		}
		// recursive case
		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		}
		return current; // if value is equal to the value of current node, ignore insertion
	}

	// check if the tree is empty
	public boolean isEmpty() {
		return root == null;
	}

	// determine size of tree
	public int getSize() {
		return getSizeRecursive(root);
	}

	// how big is the tree underneath this node (including this node)?
	private int getSizeRecursive(TreeNode current) {
		// base case: current node is null, no nodes are beneath it
		// ternary operator: [condition] ? [value to return if condition is true] :
		// [value to return if condition is false]
		return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
	}
	
	// does the tree contain the given value?
	public boolean containsNode(int value ) {
		return false;
	}

	// inner class
	// we never actually need TreeNode outside the binary tree
	// can't make this public
	private class TreeNode {

		int value;
		TreeNode left;
		TreeNode right;

		TreeNode(int value) {
			this.value = value;
			right = null;
			left = null;
		}
	}

}
