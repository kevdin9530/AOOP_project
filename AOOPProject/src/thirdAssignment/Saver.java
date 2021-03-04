package thirdAssignment;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Saver {
	public String save(Object o) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {	
		String a = "";
		Class<?> c = o.getClass();
		for(Method m:c.getDeclaredMethods()){
			SubElements selement = m.getAnnotation(SubElements.class);
			ElementField efield = m.getAnnotation(ElementField.class);
			Object []  help	= null;
			if(selement != null){
				help = (Object[]) m.invoke(o);
			}
			if(efield != null){
				a = "<node value=" + '"' + m.invoke(o) + '"' + "> \n";
				}
			if(help != null){
				a = a + "	" + "</subnode>" + "\n";
				for(Object child : help){					
					a = a + "		" + save(child);		
				}
				a = a +"	"+ "</subnode>" + "\n" + "</node>";
			}
		}
		return a;
		}
	

	
	
	public static void main(String[] args1) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Tree<String> t =
				new Tree<String>("top",
				new Tree[] {
				new Tree("sub1"),
				new Tree("sub2"),
				new Tree("sub8"),
				new Tree("sub9"),
				});
		Saver s = new Saver();
		String r = s.save(t);
		System.out.println(r);
	}
}
