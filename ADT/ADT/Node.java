package ADT;


/*
 * oggetto nodo
 * contiene oggetti di tipo record
 * */
public class Node<K extends Comparable<K>, V>{
	
	private K key;
	private V value;
	public Node<K, V> left, right;//puntatori ai nodi figli
	public Node p = null;
	
	
	//costruttore vuoto
	public Node(){
			
			this.key = null;
			this.value = null;
			this.left = null;
			this.right = null;
			
	}
	
	//costruttore 
	public Node(K k, V v){
		
		this.key = k;
		this.value = v;
		this.left = null;
		this.right = null;
		
	}
	
	public K getKey(){
		return this.key;
	}
	
	public void setKey(K k){
		this.key = k;
	}
	
	public void setValue(V v){
		this.value = v;
	}
	
	public V getValue(){
		return this.value;
	}
	
		
	public int compareTo(K key){
		return this.getKey().compareTo(key);
	}
	
}

