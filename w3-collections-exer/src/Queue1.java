import java.util.PriorityQueue;

public class Queue1 {

	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<String>();
		
		queue.add("Green");
		queue.add("Blue");
		queue.add("Yellow");
		queue.add("Red"); 
		PriorityQueue<String> queue1 = new PriorityQueue<String>();
		
		queue1.addAll(queue);
		
		System.out.println(queue1);
	}

}
