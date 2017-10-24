package ADT;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

	/*
	 * leggo i dati dal file
	 * li inserisco nell'oggetto records
	 * inserisco l'oggetto records nell'albero
	 * 
	 * */

		public static void main(String[] args) {
			
			BufferedReader f = null;
			Node bNodo;
			RbNode rbNodo;
			Comparable k = null;
			FileReader input;
			String linea ;
			int rb;
			Bst t = new Bst<>();
			Rbt r = new Rbt<>();
			
			try{
				
				while(true){
					//menu per sciegliere che tipo di alberi usare
					
					System.out.println("*************************************");
		 			System.out.println("* 1) B Tree                         *");
		 			System.out.println("* 2) Rb Tree                        *");
		 			System.out.println("*************************************");
					
		 			BufferedReader campo = new BufferedReader(new InputStreamReader(System.in) );
		            System.out.print("Scegli chiave: ");
		            //serve per decidere che tipo di albero creare
		            rb = Integer.parseInt( campo.readLine());
					
		            if(rb>0 && rb<3){// esce dal menu quando si sceglie una opzione corretta
		            	break;
		            }
				}
				//menu per il tipo di chiave da usare
				System.out.println("*************************************");
	 			System.out.println("* 1) Field1                         *");
	 			System.out.println("* 2) Field2                         *");
	 			System.out.println("* 3) Field3                         *");
	 			System.out.println("*************************************");
	 			
	 			BufferedReader campo = new BufferedReader(new InputStreamReader(System.in) );
	            System.out.print("Scegli chiave: ");
	            int field = Integer.parseInt( campo.readLine());
				
				input = new FileReader("src/file.csv");
				f = new BufferedReader(input); 


				
				
				//tempo di inserimento
				long inizio = System.currentTimeMillis();
				
				
				/*
				 * va a riempire l'albero con ogni riga letta
				 * */
				
				while((linea = f.readLine()) != null){

					int id = Integer.parseInt(linea.split(",")[0]);
					String field1 = linea.split(",")[1];
					int field2 = Integer.parseInt(linea.split(",")[2]);
					float field3 = Float.parseFloat(linea.split(",")[3]);
					
					Record record = new Record(id, field1, field2, field3 );
					
					//inserisco la chiave scelta dal menu
					/*
					 * 1 binay tree
					 * 2 red black tree
					 * */						
					switch (rb) {
					case 1:
						switch (field) {
						//creazione del nodo bt
						case 1: bNodo = new Node(record.getField1(), record);			
							break;
						case 2: bNodo = new Node(record.getField2(), record);
							break;
						case 3: bNodo = new Node(record.getField3(), record);
							break;	
						default: bNodo = new Node(record.getField1(), record);
							break;
						}
						t.insert(bNodo);// inserisco i dati nell Btree

						break;
					case 2:	
						switch (field) {
						//creazione del nodo rbt
						case 1: rbNodo = new RbNode(record.getField1(), record);			
							break;
						case 2: rbNodo = new RbNode(record.getField2(), record);
							break;
						case 3: rbNodo = new RbNode(record.getField3(), record);
							break;	
						default: rbNodo = new RbNode(record.getField1(), record);
							break;
						
													
						}
						r.rbInsert(rbNodo);//inserisco i dati nel rbTree
						break;
						
				}
					
					
					
						
				}
				//chiudo il file
				try{
					f.close();
				}
				catch (IOException ex){
					System.out.println("Errore chiusura file");
				}
				
				
				//fine tempo
				long fine = System.currentTimeMillis();
				
				long tot = (fine - inizio)/1000;
				System.out.println(tot);




				//a ogni operazione mostra il menu fino a quando non si preme exit
				while(true){

					System.out.println("*************************************");
		 			System.out.println("* 1) Cerca 1 milione di chiavi      *");
		 			System.out.println("* 2) Rimuovi 1 milione di chiavi    *");
		 			System.out.println("* 3) Grandezza Albero               *");
		 			System.out.println("* 4) Stampa Inorder                 *");
		 			System.out.println("* 5) EXIT                           *");
		 			System.out.println("*************************************");
		 			
		 			BufferedReader metodo = new BufferedReader(new InputStreamReader(System.in) );
		            System.out.print("Scegli: ");
		            int tipo = Integer.parseInt( metodo.readLine());
					
		            input = new FileReader("src/rec.csv");
					f = new BufferedReader(input); 
		           
					//viene cercata la chiave scelta nel menu
					//vengono cercate 1 milione di chiavi lette da un file
		            switch (tipo) {
						case 1:
							long inizioB = System.currentTimeMillis();
							while((linea = f.readLine()) != null){
								switch(field){
									//viene presa la chiave sceglia tramite il menu
									case 1: k = linea.split(",")[1]; 
											break;
									case 2: k = Integer.parseInt(linea.split(",")[2]);
											break;
									case 3:	k = Float.parseFloat(linea.split(",")[3]);
											break;
									
								}
								
								if(rb == 1){
									t.search(k);

								}
								else if(rb == 2){



									r.search(k);



								}
								
							}
							long fineB = System.currentTimeMillis();

							long totB = (fineB - inizioB)/1000;
							System.out.println(totB);
						break;
						// vengono eliminate 1 milione di chiavi lette da un file	
						case 2:
							long iniziorT = System.currentTimeMillis();
							while((linea = f.readLine()) != null){
								switch(field){
								
									case 1: k = linea.split(",")[1]; 
											break;
									case 2: k = Integer.parseInt(linea.split(",")[2]);
											break;
									case 3:	k = Float.parseFloat(linea.split(",")[3]);
											break;
									
								}
								if(rb == 1){



									t.remove(k);



								}
								else if(rb == 2){



									r.rbRemove(k);


								}
								
							}
							long finerT = System.currentTimeMillis();

							long totrT = (finerT - iniziorT)/1000;
							System.out.println(totrT);
							break;
						
						//viene stampata la grandezza dell'albero	
						case 3:
							if(rb == 1){
								System.out.println(t.size());
							}
							else if(rb == 2){
								System.out.println(r.size());
							}
													
							break;	
						case 4:
							if(rb == 1){
								t.print();
							}
							else if(rb == 2){
								r.print();
							}
							
							break;
						case 5:  
							System.exit(0);
							break;
						default: System.exit(0);
							break;
						}

					//chiudo il file
		            try{
						f.close();
					}
					catch (IOException ex){
						System.out.println("Errore chiusura file");
					}



				}
				
				


				

			}
			catch (IOException ex){
				System.out.println("Errore File");
			}
			catch(NullPointerException e){
				e.printStackTrace();
				System.out.println("puntatore a NULL" );
			}
			catch(Exception e){
				System.out.println("verificato un errore");
			}

			
		}
		
}
