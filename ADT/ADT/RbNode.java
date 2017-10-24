package ADT;

//contiene oggetti di tipo record
//estende oggetto node
public class RbNode<K extends Comparable<K>, V> extends Node {
	
	private boolean Red = false;
	
	//costruttore vuoto
	public RbNode(){
		super();
		
	}
	
	public RbNode(K k, V v){
		super(k, v);
	}
	
	public boolean isRed(){
		return Red;
	}
	
	public boolean isBlack(){
		return !Red;
	}
	
	public void setRed(){
		this.Red = true;
	}
	
	public void setBlack(){
		this.Red = false;
	}

}
