import java.util.TreeSet;

public class TreeSet5 {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("Green");
		treeSet.add("Blue");
		treeSet.add("Yellow");
		treeSet.add("Red");    
		
		System.out.println(treeSet.remove("Green"));
		System.out.println(treeSet);
	}

}
