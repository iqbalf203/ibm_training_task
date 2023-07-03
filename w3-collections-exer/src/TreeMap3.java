import java.util.TreeMap;

public class TreeMap3 {

	public static void main(String[] args) {
		TreeMap<Integer,String> treeMap = new TreeMap<Integer,String>();
		
		treeMap.put(1,"Green");
		treeMap.put(2,"Blue");
		treeMap.put(3,"Yellow");
		treeMap.put(4,"Red"); 
		System.out.println(treeMap.containsKey(1));
	}

}
