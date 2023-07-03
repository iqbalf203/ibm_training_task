import java.util.TreeSet;

public class TreeSet4 {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("Green");
		treeSet.add("Blue");
		treeSet.add("Yellow");
		treeSet.add("Red");    
		
		System.out.println(treeSet.pollLast());
		System.out.println(treeSet);
	}

}
