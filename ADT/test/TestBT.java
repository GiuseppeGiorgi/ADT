package test;

import ADT.*;
import org.junit.Assert;
import org.junit.Test;

public class TestBT {

    @Test
    public void field1Test(){
        Node Nodo1 = new Node("noto",new Record(Integer.parseInt("0"), "noto", Integer.parseInt("233460"), Float.parseFloat("32209.073312")));
        Node Nodo2 = new Node("voler",new Record(Integer.parseInt("1049304"), "voler", Integer.parseInt("4113409"), Float.parseFloat("59758.826758")));
        Node Nodo3 = new Node("angeli",new Record(Integer.parseInt("15295684"), "angeli", Integer.parseInt("233460"), Float.parseFloat("65797.579034")));
        Node Nodo4 = new Node("qualitade",new Record(Integer.parseInt("13457501"), "qualitade", Integer.parseInt("918243"), Float.parseFloat("26709.869539")));
        Node Nodo5 = new Node("profeti",new Record(Integer.parseInt("2973058"), "profeti", Integer.parseInt("2745805"), Float.parseFloat("3407.935311")));

        Bst t = new Bst();

        t.insert(Nodo1);
        t.insert(Nodo2);
        t.insert(Nodo3);
        t.insert(Nodo4);
        t.insert(Nodo5);

        Assert.assertEquals("noto", t.getRoot().getKey() );
        Assert.assertEquals("angeli", t.getRoot().left.getKey() );
        Assert.assertEquals("voler", t.getRoot().right.getKey() );
        Assert.assertEquals("qualitade", t.getRoot().right.left.getKey() );
        Assert.assertEquals("profeti", t.getRoot().right.left.left.getKey() );




        t.remove("noto");

        Assert.assertEquals("profeti", t.getRoot().getKey() );
        Assert.assertEquals("angeli", t.getRoot().left.getKey() );
        Assert.assertEquals("voler", t.getRoot().right.getKey() );
        Assert.assertEquals("qualitade", t.getRoot().right.left.getKey() );



        t.remove("qualitade");

        Assert.assertEquals("profeti", t.getRoot().getKey() );
        Assert.assertEquals("angeli", t.getRoot().left.getKey() );
        Assert.assertEquals("voler", t.getRoot().right.getKey() );



    }


    @Test
    public void field2Test(){
        Node Nodo1 = new Node(Integer.parseInt("234460"),new Record(Integer.parseInt("0"), "noto", Integer.parseInt("233460"), Float.parseFloat("32209.073312")));
        Node Nodo2 = new Node(Integer.parseInt("4113409"),new Record(Integer.parseInt("1049304"), "voler", Integer.parseInt("4113409"), Float.parseFloat("59758.826758")));
        Node Nodo3 = new Node(Integer.parseInt("233460"),new Record(Integer.parseInt("15295684"), "angeli", Integer.parseInt("233460"), Float.parseFloat("65797.579034")));
        Node Nodo4 = new Node(Integer.parseInt("918243"),new Record(Integer.parseInt("13457501"), "qualitade", Integer.parseInt("918243"), Float.parseFloat("26709.869539")));
        Node Nodo5 = new Node(Integer.parseInt("2745805"),new Record(Integer.parseInt("2973058"), "profeti", Integer.parseInt("2745805"), Float.parseFloat("3407.935311")));

        Bst t = new Bst();

        t.insert(Nodo1);
        t.insert(Nodo2);
        t.insert(Nodo3);
        t.insert(Nodo4);
        t.insert(Nodo5);


        Assert.assertEquals(234460, t.getRoot().getKey() );
        Assert.assertEquals(233460, t.getRoot().left.getKey() );
        Assert.assertEquals(4113409, t.getRoot().right.getKey() );
        Assert.assertEquals(918243, t.getRoot().right.left.getKey() );
        Assert.assertEquals(2745805, t.getRoot().right.left.right.getKey() );




        t.remove(233460);

        Assert.assertEquals(234460, t.getRoot().getKey() );
        Assert.assertEquals(4113409, t.getRoot().right.getKey() );
        Assert.assertEquals(918243, t.getRoot().right.left.getKey() );
        Assert.assertEquals(2745805, t.getRoot().right.left.right.getKey() );



        t.remove(233460);

        Assert.assertEquals(234460, t.getRoot().getKey() );
        Assert.assertEquals(4113409, t.getRoot().right.getKey() );
        Assert.assertEquals(918243, t.getRoot().right.left.getKey() );
        Assert.assertEquals(2745805, t.getRoot().right.left.right.getKey() );


    }

    @Test
    public void field3Test(){
        Node Nodo1 = new Node(Float.parseFloat("32209.073312"),new Record(Integer.parseInt("0"), "noto", Integer.parseInt("233460"), Float.parseFloat("32209.073312")));
        Node Nodo2 = new Node(Float.parseFloat("59758.826758"),new Record(Integer.parseInt("1049304"), "voler", Integer.parseInt("4113409"), Float.parseFloat("59758.826758")));
        Node Nodo3 = new Node(Float.parseFloat("65797.579034"),new Record(Integer.parseInt("15295684"), "angeli", Integer.parseInt("233460"), Float.parseFloat("65797.579034")));
        Node Nodo4 = new Node(Float.parseFloat("26709.869539"),new Record(Integer.parseInt("13457501"), "qualitade", Integer.parseInt("918243"), Float.parseFloat("26709.869539")));
        Node Nodo5 = new Node(Float.parseFloat("3407.935311"),new Record(Integer.parseInt("2973058"), "profeti", Integer.parseInt("2745805"), Float.parseFloat("3407.935311")));

        Bst t = new Bst();

        t.insert(Nodo1);
        t.insert(Nodo2);
        t.insert(Nodo3);
        t.insert(Nodo4);
        t.insert(Nodo5);


        Assert.assertEquals(Float.parseFloat("32209.074"), t.getRoot().getKey() );
        Assert.assertEquals(Float.parseFloat("26709.869539"), t.getRoot().left.getKey() );
        Assert.assertEquals(Float.parseFloat("59758.83"), t.getRoot().right.getKey() );
        Assert.assertEquals(Float.parseFloat("65797.579034"), t.getRoot().right.right.getKey() );
        Assert.assertEquals(Float.parseFloat("3407.935311"), t.getRoot().left.left.getKey() );




        t.remove(Float.parseFloat("32209.073312"));

        Assert.assertEquals(Float.parseFloat("59758.826758"), t.getRoot().getKey() );
        Assert.assertEquals(Float.parseFloat("26709.869539"), t.getRoot().left.getKey() );
        Assert.assertEquals(Float.parseFloat("65797.579034"), t.getRoot().right.getKey() );
        Assert.assertEquals(Float.parseFloat("3407.935311"), t.getRoot().left.left.getKey() );


    }




}
