package test;

import ADT.*;
import org.junit.Assert;
import org.junit.Test;


public class TestADT {

    @Test
    public void field1Test(){


        RbNode rbNodo1 = new RbNode("noto",new Record(Integer.parseInt("0"), "noto", Integer.parseInt("233460"), Float.parseFloat("32209.073312")));
        RbNode rbNodo2 = new RbNode("voler",new Record(Integer.parseInt("1049304"), "voler", Integer.parseInt("4113409"), Float.parseFloat("59758.826758")));
        RbNode rbNodo3 = new RbNode("angeli",new Record(Integer.parseInt("15295684"), "angeli", Integer.parseInt("233460"), Float.parseFloat("65797.579034")));
        RbNode rbNodo4 = new RbNode("qualitade",new Record(Integer.parseInt("13457501"), "qualitade", Integer.parseInt("918243"), Float.parseFloat("26709.869539")));
        RbNode rbNodo5 = new RbNode("profeti",new Record(Integer.parseInt("2973058"), "profeti", Integer.parseInt("2745805"), Float.parseFloat("3407.935311")));

        Rbt t = new Rbt();

        t.rbInsert(rbNodo1);
        t.rbInsert(rbNodo2);
        t.rbInsert(rbNodo3);
        t.rbInsert(rbNodo4);
        t.rbInsert(rbNodo5);

        Assert.assertEquals("noto", t.getRoot().getKey() );
        Assert.assertEquals("angeli", t.getRoot().left.getKey() );
        Assert.assertEquals("qualitade", t.getRoot().right.getKey() );
        Assert.assertEquals("voler", t.getRoot().right.right.getKey() );
        Assert.assertEquals("profeti", t.getRoot().right.left.getKey() );
        Assert.assertTrue( t.getRoot().isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right.right).isRed());
        Assert.assertTrue( ((RbNode)t.getRoot().right.left).isRed());




        t.rbRemove("noto");

        Assert.assertEquals("profeti", t.getRoot().getKey() );
        Assert.assertEquals("angeli", t.getRoot().left.getKey() );
        Assert.assertEquals("qualitade", t.getRoot().right.getKey() );
        Assert.assertEquals("voler", t.getRoot().right.right.getKey() );
        Assert.assertTrue( t.getRoot().isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right.right).isRed());


        t.rbRemove("qualitade");

        Assert.assertEquals("profeti", t.getRoot().getKey() );
        Assert.assertEquals("angeli", t.getRoot().left.getKey() );
        Assert.assertEquals("voler", t.getRoot().right.getKey() );
        Assert.assertTrue( t.getRoot().isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right).isBlack());


        t.rbRemove("noto");

        Assert.assertEquals("profeti", t.getRoot().getKey() );
        Assert.assertEquals("angeli", t.getRoot().left.getKey() );
        Assert.assertEquals("voler", t.getRoot().right.getKey() );
        Assert.assertTrue( t.getRoot().isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right).isBlack());


    }


    @Test
    public void field2Test(){
        RbNode rbNodo1 = new RbNode(Integer.parseInt("234460"),new Record(Integer.parseInt("0"), "noto", Integer.parseInt("233460"), Float.parseFloat("32209.073312")));
        RbNode rbNodo2 = new RbNode(Integer.parseInt("4113409"),new Record(Integer.parseInt("1049304"), "voler", Integer.parseInt("4113409"), Float.parseFloat("59758.826758")));
        RbNode rbNodo3 = new RbNode(Integer.parseInt("233460"),new Record(Integer.parseInt("15295684"), "angeli", Integer.parseInt("233460"), Float.parseFloat("65797.579034")));
        RbNode rbNodo4 = new RbNode(Integer.parseInt("918243"),new Record(Integer.parseInt("13457501"), "qualitade", Integer.parseInt("918243"), Float.parseFloat("26709.869539")));
        RbNode rbNodo5 = new RbNode(Integer.parseInt("2745805"),new Record(Integer.parseInt("2973058"), "profeti", Integer.parseInt("2745805"), Float.parseFloat("3407.935311")));

        Rbt t = new Rbt();

        t.rbInsert(rbNodo1);
        t.rbInsert(rbNodo2);
        t.rbInsert(rbNodo3);
        t.rbInsert(rbNodo4);
        t.rbInsert(rbNodo5);


        Assert.assertEquals(234460, t.getRoot().getKey() );
        Assert.assertEquals(233460, t.getRoot().left.getKey() );
        Assert.assertEquals(2745805, t.getRoot().right.getKey() );
        Assert.assertEquals(4113409, t.getRoot().right.right.getKey() );
        Assert.assertEquals(918243, t.getRoot().right.left.getKey() );
        Assert.assertTrue( t.getRoot().isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right.right).isRed());
        Assert.assertTrue( ((RbNode)t.getRoot().right.left).isRed());



        t.rbRemove(233460);

        Assert.assertEquals(2745805, t.getRoot().getKey() );
        Assert.assertEquals(234460, t.getRoot().left.getKey() );
        Assert.assertEquals(4113409, t.getRoot().right.getKey() );
        Assert.assertEquals(918243, t.getRoot().left.right.getKey() );
        Assert.assertTrue( t.getRoot().isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left.right).isRed());


        t.rbRemove(233460);

        Assert.assertEquals(2745805, t.getRoot().getKey() );
        Assert.assertEquals(234460, t.getRoot().left.getKey() );
        Assert.assertEquals(4113409, t.getRoot().right.getKey() );
        Assert.assertTrue( t.getRoot().isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right).isBlack());

    }

    @Test
    public void field3Test(){
        RbNode rbNodo1 = new RbNode(Float.parseFloat("32209.073312"),new Record(Integer.parseInt("0"), "noto", Integer.parseInt("233460"), Float.parseFloat("32209.073312")));
        RbNode rbNodo2 = new RbNode(Float.parseFloat("59758.826758"),new Record(Integer.parseInt("1049304"), "voler", Integer.parseInt("4113409"), Float.parseFloat("59758.826758")));
        RbNode rbNodo3 = new RbNode(Float.parseFloat("65797.579034"),new Record(Integer.parseInt("15295684"), "angeli", Integer.parseInt("233460"), Float.parseFloat("65797.579034")));
        RbNode rbNodo4 = new RbNode(Float.parseFloat("26709.869539"),new Record(Integer.parseInt("13457501"), "qualitade", Integer.parseInt("918243"), Float.parseFloat("26709.869539")));
        RbNode rbNodo5 = new RbNode(Float.parseFloat("3407.935311"),new Record(Integer.parseInt("2973058"), "profeti", Integer.parseInt("2745805"), Float.parseFloat("3407.935311")));

        Rbt t = new Rbt();

        t.rbInsert(rbNodo1);
        t.rbInsert(rbNodo2);
        t.rbInsert(rbNodo3);
        t.rbInsert(rbNodo4);
        t.rbInsert(rbNodo5);


        Assert.assertEquals(Float.parseFloat("59758.826758"), t.getRoot().getKey() );
        Assert.assertEquals(Float.parseFloat("26709.869539"), t.getRoot().left.getKey() );
        Assert.assertEquals(Float.parseFloat("65797.579034"), t.getRoot().right.getKey() );
        Assert.assertEquals(Float.parseFloat("32209.073312"), t.getRoot().left.right.getKey() );
        Assert.assertEquals(Float.parseFloat("3407.935311"), t.getRoot().left.left.getKey() );
        Assert.assertTrue( t.getRoot().isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left.right).isRed());
        Assert.assertTrue( ((RbNode)t.getRoot().left.left).isRed());



        t.rbRemove(Float.parseFloat("32209.073312"));

        Assert.assertEquals(Float.parseFloat("59758.826758"), t.getRoot().getKey() );
        Assert.assertEquals(Float.parseFloat("26709.869539"), t.getRoot().left.getKey() );
        Assert.assertEquals(Float.parseFloat("65797.579034"), t.getRoot().right.getKey() );
        Assert.assertEquals(Float.parseFloat("3407.935311"), t.getRoot().left.left.getKey() );
        Assert.assertTrue( t.getRoot().isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().right).isBlack());
        Assert.assertTrue( ((RbNode)t.getRoot().left.left).isRed());






    }


}
