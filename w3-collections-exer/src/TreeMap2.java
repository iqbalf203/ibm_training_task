import java.util.TreeMap;

public class TreeMap2 {

	public static void main(String[] args) {
		TreeMap<Integer,String> treeMap = new TreeMap<Integer,String>();
		
		treeMap.put(1,"Green");
		treeMap.put(2,"Blue");
		treeMap.put(3,"Yellow");
		treeMap.put(4,"Red"); 
		
TreeMap<Integer,String> treeMap1 = new TreeMap<Integer,String>();

	treeMap1.putAll(treeMap);
	
		System.out.println(treeMap1);
	}

}
