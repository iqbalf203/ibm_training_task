import java.util.Set;
import java.util.TreeMap;

public class TreeMap5 {

	public static void main(String[] args) {
		TreeMap<Integer,String> treeMap = new TreeMap<Integer,String>();
		
		treeMap.put(1,"Green");
		treeMap.put(2,"Blue");
		treeMap.put(3,"Yellow");
		treeMap.put(4,"Red"); 
		
		Set<Integer> keys = treeMap.keySet();
		
		for(int i:keys) {
					System.out.println(i);

		}
	}

}
