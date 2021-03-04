package secondAssignment.TreeVisitor;
import java.util.*;
public class TreePrintVisitor <T> implements TreeVisitor<T, String>{
	
	
	@Override
	public String visit(Tree<T> t) {
		return t.accept(this);
	}

	@Override
	public String visit(Leaf<T> l) {
		return l.getValue().toString();
	}

	@Override
	public String visit(Node<T> n) {
		String a = "";
		String b = "";
		
		for (Tree<T> child : n.getChildren()) {

			b = b +  "  ";
			a =   a  + "\n" + b + child.accept(this) ;
			
		}
		return  a ;
	}

}
