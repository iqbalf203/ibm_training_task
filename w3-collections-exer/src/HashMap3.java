import java.util.HashMap;

public class HashMap3 {

	public static void main(String[] args) {
		HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
		
		hashMap.put(1,"Green");
		hashMap.put(2,"Blue");
		hashMap.put(3,"Yellow");
		hashMap.put(4,"Red"); 
		
HashMap<Integer,String> hashMap1 = new HashMap<Integer,String>();
		
	hashMap1.putAll(hashMap);
		
		System.out.println(hashMap1);
	}

}
