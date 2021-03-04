package secondAssignment.TreeVisitor;

import java.util.ArrayList;
import java.util.List;

public class TestVisitors {
	public static void main(String[] args) {
		args = new String[] { "one", "two", "three", "four","five" };
		List<Tree<String>> leaves = new ArrayList<Tree<String>>();
		for (int i = 0; i < args.length; i++)
			leaves.add(new Leaf<String>(args[i]));
		Tree<String> t1 = new Node<String>(leaves);
		Tree<String> t2 = new Node<String>(leaves);
		Tree<String> t3 = new Node<String>(leaves);
		List<Tree<String>> lst = new ArrayList<Tree<String>>();
		lst.add(t1);
		lst.add(t2);
		lst.add(t3);
		Tree<String> t = new Node<String>(lst);	
		TreeVisitor<String, String> tpv = new TreePrintVisitor<String>();	
		System.out.println("Tree: "+t.accept(tpv));
	}
}
