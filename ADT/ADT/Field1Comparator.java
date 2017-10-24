package ADT;

import java.util.Comparator;



public class Field1Comparator implements Comparator<Node>{
	
	@Override
	public int compare(Node n1, Node n2){
		
		String f1 = (String)n1.getKey();
		String f2 = (String)n2.getKey();
				
		return f2.compareTo(f2);
	}
}



/*
public class Field1Comparator<K, V> implements Comparator<Node<K, V>> {
	
	
	
	@Override
	public int compare(Node<K, V> n1, Node<K, V> n2){
		K f1 = n1.getKey();
		K f2 = n2.getKey();
		
		
		
		return 0;
	}
	

}
*/
