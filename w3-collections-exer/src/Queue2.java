import java.util.PriorityQueue;

public class Queue2 {

	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<String>();
		
		queue.add("Green");
		queue.add("Blue");
		queue.add("Yellow");
		queue.add("Red"); 
		
		queue.offer("White");
		
		System.out.println(queue);
	}

}
