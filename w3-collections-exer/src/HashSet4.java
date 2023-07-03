import java.util.HashSet;

public class HashSet4 {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		
		hashSet.add("Green");
		hashSet.add("Blue");
		hashSet.add("Yellow");
		hashSet.add("Red");
		
		HashSet<String> hashSet1 = new HashSet<String>();
		
		hashSet1 = (HashSet)hashSet.clone();
		
		System.out.println(hashSet1);
	}

}
