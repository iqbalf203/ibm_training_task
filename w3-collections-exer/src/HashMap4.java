import java.util.HashMap;

public class HashMap4 {

	public static void main(String[] args) {
		HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
		
		hashMap.put(1,"Green");
		hashMap.put(2,"Blue");
		hashMap.put(3,"Yellow");
		hashMap.put(4,"Red"); 
		
		hashMap.clear();
		
		System.out.println(hashMap);
	}

}
