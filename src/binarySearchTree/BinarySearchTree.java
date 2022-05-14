package binarySearchTree;

public class BinarySearchTree {
// BST node
	static class Node {
		int key;
		Node left, right;
	};

	// creation of new node
	static Node newNode(int data) {
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	static Node insert(Node root, int key) {
		Node newnode = newNode(key);
		Node x = root;
		Node current_parent = null;
		while (x != null) {
			current_parent = x;
			if (key < x.key)
				x = x.left;
			else if (key > x.key)
				x = x.right;
			else {
				System.out.println("Value already exists!!!");
				return newnode;
			}
		}
		// If the root is null, the tree is empty.
		if (current_parent == null)
			current_parent = newnode;
		// assign new node node to the left child
		else if (key < current_parent.key)
			current_parent.left = newnode;
		// assign the new node to the right child
		else
			current_parent.right = newnode;
		// return pointer to new node
		return current_parent;
	}

	//display node values in ascending order (Inorder traversal)
	static void Inorder(Node root) {
		if (root == null)
			return;
		else {
			Inorder(root.left);
			System.out.print(root.key + " ");
			Inorder(root.right);
		}
	}

	public static void main(String args[]) {
		int value;
	//	boolean status;
		Node root = null;
		int[] arr = { 60, 55, 50, 10,30};
		for (int i = 0; i < arr.length; i++) {
			value = arr[i];
			if (root == null) {
				root = insert(root, value);
			} else {
				insert(root, value);
			}
		}
		System.out.println("Node values of BST in ascending order!!\n");
		Inorder(root);
		}
}
