/**
 * Author: Ryan Lukas
 * Date: Firday, October 27, 2017
 */
package assignment05;
import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

public class TagTree 
{
	
	private static Node root;
	private static StringBuilder outPut;
	private static boolean tree;
	private int level, count;
	
	
	/**
	 * Constructor: Creates new tree
	 * @param s
	 */
	public TagTree(Scanner s){
		s.next();
		root = parse(s);
	}
	
	/**
	 * returns hieght of tree, height at root is 0
	 *
	 * @return
	 */
	public int getHeight(){
		return getHeight(root);
	}
	
	/**
	 * finds node with most children
	 * @return int of max children
	 */
	public int getMaxDegree(){
		return getMaxDegree(root);
	}
	
	/**
	 * pre-order traversal of tree
	 * @return string
	 */
	public String outputPrefix(){
		outPut = new StringBuilder();
		if(root.data == null){
			return outPut.toString();
		}
		if(root.children.size() ==0){
			outPut.append(root);
			return outPut.toString();
		}
		outputPrefix(root);
		return outPut.toString();
	}
	
	/**
	 * post-order traversal of tree
	 * @return string
	 */
	public String outputPostfix(){
		outPut = new StringBuilder();
		if(root.data == null){
			return outPut.toString();
		}
		if(root.children.size() ==0){
			outPut.append(root);
			return outPut.toString();
		}
		outputPostfix(root);
		return outPut.toString();
	}
	
	/**
	 * Checks if it is a binary tree
	 * Must have no more than 2 children
	 * @return
	 */
	public boolean isBinaryTree(){
		if(root.children.size() == 0){
			return true;
		}
		tree = true;
		return isBinaryTree(root);
	}
	
	/**
	 * Checks if the tree is a two tree
	 * Must have 0 children or 2 children only
	 * @return boolean
	 */
	public boolean isTwoTree(){
		if(root.children.size() == 0){
			return true;
		}
		tree = true;
		return isTwoTree(root);
	}
	
	/**
	 * all levels are full for a binary tree
	 * @return boolean
	 */
	public boolean isFullBinaryTree(){
		if(root.children.size() == 0){
			return true;
		}
		tree = true;
		level = 1;
		int x = getHeight();
		return isFullBinaryTree(root,x);
	}
	
	/**
	 * finds depth of where the string is located
	 * @param x
	 * @return
	 */
	public int findDepth(String x){
		level = -1;
		count = 0;
		tree = false;
		return findDepth(x, root);
	}
	
	/**
	 * private helper for find depth, recursive call on node to go through all children
	 * @param x
	 * @param r
	 * @return
	 */
	private int findDepth(String x, Node r){
		if(x.equals(root.data)){
			level = 0;
			tree = true;
		}
		if(tree == true){
			return level;
		}
		if(r.data.equals(x)){
			level = count;
			tree = true;
		}
		for (Node n : r.children) {
			count++;
			findDepth(x,n);
			count--;
		}
		return level;
	}
	
	/**
	 * private helper method for isFullBinaryTree, recursive call on node to go through all children
	 * @param r
	 * @param height
	 * @return
	 */
	private boolean isFullBinaryTree(Node r, int height){
		if(tree == false){
			return tree;
		}
		if(r.children.size() == 1){
			tree = false;
		}
		if(level < height && r.children.size() ==0){
			tree = false;
		}
		
		for (Node n : r.children) {
			level++;
			isFullBinaryTree(n,height);
			level--;
		}
		return tree;
	}
	
	/**
	 * private helper method for isTwoTree, recursive call on node to go through all children
	 * @param r
	 * @return
	 */
	private boolean isTwoTree(Node r){
		if(tree == false){
			return tree;
		}
		if(root.children.size() == 0){
			tree = true;
		}
		if(!(r.children.size() == 0 || r.children.size() == 2)){
			tree = false;
		}
		for (Node n : r.children) {
			isTwoTree(n);
		}
		return tree;
	}
	
	/**
	 * private helper method for isBinaryTree, recursive call on node to go through all children
	 * @param r
	 * @return
	 */
	private boolean isBinaryTree(Node r){
		if(tree == false){
			return tree;
		}
		if(root.children.size() == 0){
			tree = true;
		}
		if (r.children.size() > 2) {
			tree = false;
		}
		for (Node n : r.children) {
			isBinaryTree(n);
		}

		return tree;
		
	}
	
	/**
	 * private helper method for outputPostfix, recursive call on node to go through all children
	 * @param r
	 */
	private void outputPostfix(Node r){
		if(r.children.size() == 0){
			outPut.append(r.data);
			outPut.append(" ");
			return;
		}
		for(Node n: r.children){
			outputPostfix(n);
		}
		outPut.append(r.data);
		outPut.append(" ");
		
	}
	
	/**
	 * private helper method for outputPrefix, recursive call on node to go through all children
	 * @param r
	 */
	private void outputPrefix(Node r){
		if(r.children.size() == 0){
			outPut.append(r.data);
			outPut.append(" ");
			return;
		}
		outPut.append(r.data);
		outPut.append(" ");
		for(Node n: r.children){
			outputPrefix(n);
		}	
	
	}
	
	/**
	 * private helper method for getMaxDegree, recursive call on node to go through all children
	 * @param root
	 * @return
	 */
	private int getMaxDegree(Node root){
		if(root.children.size() ==0)
			return 0;
		int maxDegree = 0;
		maxDegree = Math.max(maxDegree, root.children.size());
		for(Node n: root.children){
			getMaxDegree(n);
		}
		return maxDegree;
	}
	
	/**
	 * private helper method for getHeight, recursive call on node to go through all children
	 * @param r
	 * @return
	 */
	private int getHeight(Node r){
		if(root.children.size() == 0)
			return 0;
		int maxHeight = 0;
		for(Node n: r.children){
			maxHeight = Math.max(maxHeight, getHeight(n));	
		}
		return maxHeight+1;
	}
	
	/**
	 * private helper method for Tag Tree , creates new tree
	 * @param s
	 * @return
	 */
	private Node parse(Scanner s){
		Node node = new Node(s.next());
		
		while (s.hasNext()) {
			String str2 = s.next();
			if (!(str2.startsWith("</")) && str2.startsWith("<")) {
				node.children.add(parse(s));
			} else if (str2.startsWith("</")) {
				return node;

			}

		}

		return node;

	}
	
	/**
	 * private method for Node
	 * @author ryanlukas
	 *
	 */
	private static class Node{
		@Override
		public String toString() {
			return "Node [data=" + data + ", child=" + children + "]";
		}

		String data;
		List<Node> children = new ArrayList<Node>();
		
		
		
		Node(String data){
			this.data = data.substring(0,data.length()-1);
		}
	}
}
