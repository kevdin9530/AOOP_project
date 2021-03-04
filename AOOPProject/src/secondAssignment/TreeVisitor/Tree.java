package secondAssignment.TreeVisitor;

public interface Tree<T> {
	<R> R accept(TreeVisitor<T, R> v);
}