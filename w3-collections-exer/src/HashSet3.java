import java.util.HashSet;

public class HashSet3 {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		
		hashSet.add("Green");
		hashSet.add("Blue");
		hashSet.add("Yellow");
		hashSet.add("Red");
		
		hashSet.removeAll(hashSet);
		
		System.out.println(hashSet);
	}

}
