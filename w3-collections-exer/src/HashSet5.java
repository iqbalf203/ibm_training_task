import java.util.HashSet;

public class HashSet5 {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		
		hashSet.add("Green");
		hashSet.add("Blue");
		hashSet.add("Yellow");
		hashSet.add("Red");
		
		hashSet.clear();
		
		System.out.println(hashSet);
	}

}
