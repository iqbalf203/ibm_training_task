import java.util.TreeSet;

public class TreeSet2 {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("Green");
		treeSet.add("Blue");
		treeSet.add("Yellow");
		treeSet.add("Red");    
		
		String ele = treeSet.first();
		
		System.out.println(ele);
	}

}
