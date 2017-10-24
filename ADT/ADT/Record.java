package ADT;

//oggetto che contiene di dati letti dal file
public class Record {
	
	private int id;
	private String field1;
	private int field2;
	private float field3;
	
	public Record(int id, String field1, int field2, float field3){
		this.id = id;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		
	}
	
	public int getId(){
		return id;
	}
	
	public String getField1(){
		return field1;
	}
	
	public int getField2(){
		return field2;
	}
	
	public float getField3(){
		return field3;
	}
	
	
	public String toString(){
		return id + ","+ field1 +","+ field2+","+field3;
	}
	
/*
	public String toString(){
		return "id ="+ id + ", field1 = "+ field1 +", field2 ="+ field2+", field3 ="+field3;
	}
*/	
	

}

