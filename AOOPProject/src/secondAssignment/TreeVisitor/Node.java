package secondAssignment.TreeVisitor;


import java.util.*;

public class Node<T> implements Tree<T> {

	private List<Tree<T>> children;

	public Node(List<Tree<T>> trees) {
		children = trees;
	}

	public String toString() {
		return getClass().getName() + "[children = " + children + "]";
	}

	public <R> R accept(TreeVisitor<T, R> v) {
		return v.visit(this);
	}
	
	public List<Tree<T>> getChildren() {
		return children;
	}

}