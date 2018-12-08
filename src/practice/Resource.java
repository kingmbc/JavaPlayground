package practice;
import java.util.function.Consumer;

public class Resource {
 
    public Resource() {
        System.out.println("Opening resource");
    }
 
    public void operate() {
        System.out.println("Operating on resource");
    }
 
    public void dispose() {
        System.out.println("Disposing resource");
    }
    
    public static void withResource(Consumer<Resource> consumer) {
	    Resource resource = new Resource();
	    try {
	        consumer.accept(resource);
	    } finally {
	        resource.dispose();
	    }
	}


}
