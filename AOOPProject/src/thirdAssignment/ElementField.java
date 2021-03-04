package thirdAssignment;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) 
@interface ElementField {

	String name();

}
