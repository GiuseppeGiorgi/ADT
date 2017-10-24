package ADT;



/*
 * uso una sentinella NILL
 * tutti i nodi null compreso root.p punta a NILL
 * */

/*
 * @insert OK
 * @delete ok
 * @search ok
 * */

public class Rbt<K extends Comparable<K>, V> extends Bst{
	//NILL  la sentinella puntata da tutti i nodi che non hanno figli compreso il parent root
	static RbNode NILL = new RbNode<>();
	protected RbNode root;
	protected RbNode y;
	protected  RbNode x;
	protected  RbNode w;

	public Rbt(){
		root = NILL;
	}

	public void rbInsert(RbNode x){

		insert(root, x);
	}

	public void print(){
		print(root);
	}

	public void rbRemove(Comparable key){


		Node nodo = search(root, key);

		if(nodo == NILL || nodo == null){
			System.out.println("La chiave "+ key + " non � presente nell'albero");
		}
		else{
			rbDelete(root,(RbNode)nodo);
		}
	}

	public RbNode search(Comparable key){

		RbNode x = (RbNode)search(root, key);
		if(x != NILL  && x != null){
			System.out.println(x.getValue());
		}
		else{
			System.out.println("la key "+ key +" non esiste nell'albero");
		}

		return x;
	}

	public int size()
	{
		return size(root);
	}



	/*-------------------------------- METODI PRIVATI---------------------------*/

	private void insert(RbNode t, RbNode z){

		y = NILL;
		x = t;

		z.p = NILL;
		z.left = NILL;
		z.right = NILL;

		while(x != NILL && !z.getKey().equals(x.getKey())){//cicla fino a quando x non punta alla sentinella NILL
			y = x;// x scende nell'albero e y punta sempre al padre di x

			if(z.getKey().compareTo(x.getKey()) < 0){//z < x
				x = (RbNode)x.left;
			}
			else{
				x = (RbNode)x.right;
			}
		}
		if (x != null && z.getKey().equals(x.getKey())){
			x.setKey(z.getKey());
			x.setValue(z.getValue());
		}
		else {

			z.p = y;

			if (y == NILL) {
				root = z;
			} else if (z.getKey().compareTo(y.getKey()) < 0) {
				y.left = z;
			} else {
				y.right = z;
			}

			z.left = (RbNode) NILL;
			z.right = (RbNode) NILL;
			z.setRed();

			RBInsertFixup(t, z);
		}

	}//end insert


	//serve per garantire che non ci siano violazioni nell'albero
	private void RBInsertFixup(RbNode t, RbNode z){

		while(((RbNode)z.p).isRed()){

			if(z.p == z.p.p.left){

				y = (RbNode)z.p.p.right;

					if(y.isRed()){
					//violazione casi 1
					((RbNode)z.p).setBlack();
					((RbNode)y).setBlack();
					((RbNode)z.p.p).setRed();
					z = ((RbNode)z.p.p);


				}
				else if(z == z.p.right){
					//violazione caso 2
					z = ((RbNode)z.p);

					leftRotate(t, z);

				}
				else{

					//violazione caso 3
					((RbNode)z.p).setBlack();
					((RbNode)z.p.p).setRed();

					rightRotate(t, (RbNode)z.p.p);

				}


			}//end ramo left
			else{

				y = (RbNode)z.p.p.left;

				if(y.isRed()){
					//violazione caso 1
					((RbNode)z.p).setBlack();
					((RbNode)y).setBlack();
					((RbNode)z.p.p).setRed();
					z = ((RbNode)z.p.p);
				}
				else if(z == z.p.left){
					//violazione caso 2
					z = ((RbNode)z.p);

					rightRotate(t, z);

				}
				else{
					//violazione caso 3
					((RbNode)z.p).setBlack();
					((RbNode)z.p.p).setRed();

					leftRotate(t, (RbNode)z.p.p);
				}


			}//end ramo right

		}//end while

		root.setBlack();
	}

	//rotazione verso sinistra
	public void leftRotate(RbNode t, RbNode x){

		y = ((RbNode)x.right);
		x.right = y.left;

		if(y.left != NILL){
			y.left.p = x;
		}
		y.p = x.p;
		if(x.p == NILL){
			root = y;
		}
		else if(x == x.p.left){
			x.p.left = y;
		}
		else {
			x.p.right = y;
		}

		y.left = x;
		x.p = y;
	}

	//rotazione verso destra
	public void rightRotate(RbNode t, RbNode x){

		y = ((RbNode)x.left);

		x.left = y.right;

		if(y.right != NILL){
			y.right.p = x;
		}
		y.p = x.p;
		if(x.p == NILL){
			root = y;
		}
		else if(x == x.p.right){
			x.p.right = y;
		}
		else {
			x.p.left = y;
		}

		y.right = x;
		x.p = y;
	}


	/*elimina un nodo dall'albero
	 * parametri
	 * @root
	 * @nodo da eliminare
	*/
	private void rbDelete(RbNode t, RbNode z){

		x = NILL;
		y = NILL;

		if(z.left == NILL || z.right == NILL){

			y = z;

		}
		else{

			y = Successor(z);//trova il successore del nodo da elimionare per sostituirlo con quello eliminato

		}
		if(y.left != NILL){
			x = (RbNode)y.left;


		}
		else{
			x = (RbNode)y.right;
		}

		x.p = y.p;

		if(y.p == NILL){
			root = x;
		}
		else if(y.p.left != NILL && y == y.p.left){
			y.p.left = x;
		}
		else if (y.p.right != NILL && y ==y.p.right){
			y.p.right = x;
		}


		if(y != z){

			z.setKey(y.getKey());
			z.setValue(y.getValue());


		}

		if(y.isBlack()){
			rbDeleteFixup(t, x);//elimina eventuali violazioni
		}

	}//end rbDelete


	private void rbDeleteFixup(RbNode t, RbNode x){

		while(x != root && x.isBlack()){

			if(x == x.p.left){

				w = (RbNode)x.p.right;

				if(w.isRed()){
					//violazione caso 1
					w.setBlack();
					((RbNode)x.p).setRed();
					leftRotate(t, (RbNode)x.p);
					w = (RbNode)x.p.right;
				}

				if(((RbNode)w.left).isBlack() && ((RbNode)w.right).isBlack()){
					//violazione caso 2
					w.setRed();
					x = (RbNode)x.p;

				}
				else{
					if(((RbNode)w.right).isBlack()){
						//violazione caso 3
						((RbNode)w.left).setBlack();
						w.setRed();
						rightRotate(t, w);
						w = (RbNode)x.p.right;
					}

					//--------violazione caso 4
					//ho messo questi if per capire se il color � rosso o nero
					//color[w]<- color[p[x]]
					if(((RbNode)x.p).isBlack()){

						w.setBlack();
					}
					else{
						w.setRed();
					}

					((RbNode)x.p).setBlack();
					((RbNode)w.right).setBlack();
					leftRotate(t, (RbNode)x.p);

					x = root;

				}

			}//end ramo left
			else{

				w = (RbNode)x.p.left;

				if(w.isRed()){
					//violazione caso 1
					w.setBlack();
					((RbNode)x.p).setRed();
					rightRotate(t, (RbNode)x.p);
					w = (RbNode)x.p.left;
				}

				if(((RbNode)w.right).isBlack() && ((RbNode)w.left).isBlack()){
					//violazione caso 2
					w.setRed();
					x = (RbNode)x.p;

				}
				else{
					if(((RbNode)w.left).isBlack()){
						//violazione caso 3
						((RbNode)w.right).setBlack();
						w.setRed();
						leftRotate(t, w);
						w = (RbNode)x.p.left;
					}

					//---- violazione caso 4
					//ho messo questi if per capire se il color � rosso o nero
					//color[w]<- color[p[x]]
					if(((RbNode)x.p).isBlack()){

						w.setBlack();
					}
					else{
						w.setRed();
					}

					((RbNode)x.p).setBlack();
					((RbNode)w.left).setBlack();
					rightRotate(t, (RbNode)x.p);

					x = root;
				}


			}//end ramo right


		}// end while

		x.setBlack();

	}

	//trova il successore di un nodo
	private RbNode Successor(RbNode x){

		if(x.right != NILL){
			return Minimum((RbNode)x.right);
		}

		y = (RbNode)x.p;

		while(y != NILL && x == y.right){
			x = y;
			y = (RbNode)y.p;
		}

		return y;

	}

	//trova il minimo
	private RbNode Minimum(RbNode x){

		while(x.left != NILL){
			x = (RbNode)x.left;
		}

		return x;
	}


	/*faccio override del metodo della super classe
	 * perchedevo controllare che il nodo sia NILL
	 * nel search della superclasse controllo che il nodo sia null
	 */
	@Override
	protected Node search(Node nodo, Comparable k){


		/*
		 * percorre l'albero
		 * confrontando la key cercata con i nodi
		 * quando viene trovata ritorna il puntatore al node
		 * altrimenti se l'albero finisce e non viene trovata ritorna null
		 * */

		if(nodo == NILL || (k.compareTo(nodo.getKey())== 0) ){

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

		if (t == NILL)
			return;

	       /* first recur on left child */
		print(t.left);

	       /* then print the data of node */
		System.out.println(t.getValue() + " ");

	       /* now recur on right child */
		print(t.right);

	}

	private int size(Node node)
	{
		if (node == NILL)
			return 0;
		else
			return(size(node.left) + 1 + size(node.right));
	}

	public RbNode getRoot() {
		return root;
	}
}//end class
