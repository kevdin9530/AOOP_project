package thirdAssignment;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) 
@interface Element {

	String name();

}
