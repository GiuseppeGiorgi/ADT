package ADT;

/*
 * usare comparator non comparable
 * */


/*
 * @insert --ok
 * @search --ok 
 * @remove --ok
 * @size   --ok
 * @print inorder --ok
 * */

public class Bst<T extends Comparable<T>> {
	
	protected Node root;//root dell'albero
	
	/*
	 * costruttore
	 * inserisce la root a null appena l'albero viene creato
	 * */
	public Bst(){
		root = null;
	}

	
	
	//METODI PUBBLICI
	
	
	/*
	 * metodo che riempie l'albero
	 * */
	public void insert(Node data){//data � l'oggetto node
		
		insert(root, data);
				
	}
	
	public void remove(Comparable key){
		
		Node x = search(root, key);//cerca il nodo da eliminare
		
		if(x != null){
			deleteNode(root, x);
		}
		else{
			System.out.println("la key "+ key +" non esiste nell'albero");
		}
	
	}
	
	//cerca una key nell'albero
	public Node search(Comparable key){
		
		Node x = search(root, key);
		if(x != null){
			System.out.println(x.getValue());
		}
		else{
			System.out.println("la key "+ key +" non esiste nell'albero");
		}
		
		return x;
	}
	//legge il metodo successor per usarlo nel metodo rbDelete
	public Node getSuccessor(Node x){
		
		return Successor(x);
	}
	
	
	
	
	public void print(){
		
		print(root);
	}
	
	
	public int size()
    {
        return size(root);
    }
	
	
//���������������������������������������������������������������������������������������������������������	
	
	
public void insert(Node t , Node data){
	
	
		Node x = t;//segue il cammino del nodo lungo l'albero
		Node y = null;//punta al padre di x
		



		while(x != null && !data.getKey().equals(x.getKey())){

				
			y = x;// punto al nodo x perche poi x passera al nodo successivo
			
			
			if(data.getKey().compareTo(x.getKey()) < 0){
				
				x = x.left;
				
			}
			else {
				
				x = x.right;
				
			}

		}//end while
	if (x != null && data.getKey().equals(x.getKey())){
		x.setKey(data.getKey());
		x.setValue(data.getValue());
	}
	else {
		data.p = y;

		if (y == null) {

			root = data;

		} else if (data.getKey().compareTo(y.getKey()) < 0) {

			y.left = data;
		} else {

			y.right = data;

		}
	}
	
	}

//riceve il puntatore al nodo da eliminare
	private Node deleteNode(Node t, Node z){
		
		Node y ;
		Node x;
				
		if(z.left == null || z.right == null){

			y = z;
			
		}
		else{
			
			y = Successor(z);
			
		}
		if(y.left != null){
			
			x = y.left;
			
		}
		else{

			x = y.right;
		}
		if(x != null){
						
			x.p = y.p;
			
		}
		if(y.p == null){

			root = x;
		}
		else if(y == y.p.left){
			
			y.p.left = x;
		}
		else{
			
			y.p.right = x;
		}
		if(y != z){
			z.setKey(y.getKey());
			z.setValue(y.getValue());
			
		}
		
		return y;
		
	}


	protected Node search(Node nodo, Comparable k){
		
		
		/*
		 * percorre l'albero
		 * confrontando la key cercata con i nodi
		 * quando viene trovata ritorna il puntatore al node
		 * altrimenti se l'albero finisce e non viene trovata ritorna null
		 * */
						
			if(nodo == null || (k.compareTo(nodo.getKey())== 0) ){
				
				return nodo;
			}
			else if(k.compareTo(nodo.getKey())<0){
												
				return search(nodo.left, k);
			}
			else {
				
				return search(nodo.right, k);
			}
    
	}


	private void print(Node t){
		 
		 if (t == null)
	           return;
	
	       /* first recur on left child */
	       print(t.left);
	
	       /* then print the data of node */
	       System.out.println(t.getValue() + " ");
	
	       /* now recur on right child */
	       print(t.right);
		 
	}
	
	private Node Successor(Node x){
		
		Node y;
		
		if(x.right != null){
			return Minimum(x.right);
		}
		
		y = x.p;
		
		while(y != null && x== y.right){
			
			x = y;
			y = y.p;
		}
		
		return y;
		
	}
	
	private Node Minimum(Node x){
		
		while(x.left != null){
			x = x.left;
		}
		
		return x;
	}

	
	private int size(Node node)
    {
        if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
    }


	public Node getRoot() {
		return root;
	}
}
