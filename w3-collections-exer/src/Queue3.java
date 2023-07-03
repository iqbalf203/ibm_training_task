import java.util.PriorityQueue;

public class Queue3 {

	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<String>();
		
		queue.add("Green");
		queue.add("Blue");
		queue.add("Yellow");
		queue.add("Red"); 
		
		queue.clear();;
		
		System.out.println(queue);
	}

}
