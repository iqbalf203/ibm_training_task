import java.util.PriorityQueue;

public class Queue5 {

	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<String>();
		
		queue.add("Green");
		queue.add("Blue");
		queue.add("Yellow");
		queue.add("Red"); 
		
		System.out.println(queue.poll());
	}

}
