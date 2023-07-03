import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Queue4 {

	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<String>();
		
		queue.add("Green");
		queue.add("Blue");
		queue.add("Yellow");
		queue.add("Red"); 
		List<String> arrQueue = new ArrayList<String>(queue);
		
		System.out.println(arrQueue);
	}

}
