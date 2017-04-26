// dllistTest.java
// Unit tests for dllist

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class dllistTest {

    @Test
    public void isEmptyTest() {
        dllist lst = new dllist();
        assertEquals(true, lst.isEmpty());
    }
    @Test
    public void secondEmptyTest(){
	dllist lst = new dllist();
	lst.insertLast("a");
	assertEquals(false, lst.isEmpty());
    }
    @Test
    public void getItemTest(){
	dllist lst = new dllist();
	lst.insertLast("a");
	assertEquals(true, lst.getItem().equals("a"));
    }
    @Test
    public void doubleInsertTest(){
	dllist lst = new dllist();
	lst.insertLast("a");
	lst.insertLast("b");
	assertEquals(true, lst.getItem().equals("b"));
    }
    @Test
    public void insertFirstTest(){
	dllist lst = new dllist();
	lst.insertFirst("a");
	lst.insertFirst("b");
	lst.insert("c",dllist.position.FIRST);
	lst.setPosition(dllist.position.FIRST);
	assertEquals(true, lst.getItem().equals("c"));
    }
    @Test
    public void insertLastTest(){
        dllist lst = new dllist();
        lst.insertFirst("a");
        lst.insertFirst("b");
        lst.insert("c",dllist.position.LAST);
        lst.setPosition(dllist.position.LAST);
        assertEquals(true, lst.getItem().equals("c"));
    }

    @Test
    public void setPositionFIRSTTest(){
	dllist lst = new dllist();
	lst.insertLast("a");
	lst.insertLast("b");
	lst.setPosition(dllist.position.FIRST);
	assertEquals(true, lst.getItem().equals("a"));
    }
    @Test
    public void setPositionLASTTest(){
        dllist lst = new dllist();
        lst.insertLast("a");
        lst.insertLast("b");
        lst.setPosition(dllist.position.LAST);
        assertEquals(true, lst.getItem().equals("b"));
    }

    @Test
    public void insertPreviousTest(){
	dllist lst = new dllist();
	lst.insert("A",dllist.position.LAST);
	lst.insert("B",dllist.position.LAST);
	lst.insert("C",dllist.position.LAST);
	lst.insert("D",dllist.position.PREVIOUS);
	lst.setPosition(dllist.position.LAST);
	assertEquals(true, lst.getItem().equals("C"));
    }
    @Test          
    public void insertAfterTest(){       
        dllist lst = new dllist();
        lst.insert("A",dllist.position.FIRST);
        lst.insert("B",dllist.position.FIRST);
        lst.insert("C",dllist.position.FIRST);
        lst.insert("D",dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.FIRST);
        assertEquals(true, lst.getItem().equals("C"));
    }
    @Test
    public void randomInsertTest(){
        dllist lst = new dllist();
        lst.insert("A",dllist.position.FIRST);
        lst.insert("B",dllist.position.LAST);
        lst.insert("C",dllist.position.LAST);
        lst.insert("D",dllist.position.PREVIOUS);
	lst.insert("E",dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.FIRST);
        assertEquals(true, lst.getItem().equals("A"));
	lst.setPosition(dllist.position.FOLLOWING);
        assertEquals(true, lst.getItem().equals("B"));
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals(true, lst.getItem().equals("D"));
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals(true, lst.getItem().equals("E"));
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals(true, lst.getItem().equals("C"));
    }
    @Test
    public void getPositionTest(){
        dllist lst = new dllist();
        lst.insert("A",dllist.position.FIRST);
        lst.insert("B",dllist.position.LAST);
        lst.insert("C",dllist.position.LAST);
        lst.insert("D",dllist.position.PREVIOUS);
        lst.insert("E",dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.FIRST);
        assertEquals(0, lst.getPosition());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals(1, lst.getPosition());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals(2, lst.getPosition());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals(3, lst.getPosition());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals(4, lst.getPosition());
    }
    @Test          
    public void deleteTest(){       
        dllist lst = new dllist();
        lst.insert("A",dllist.position.LAST);
        lst.insert("B",dllist.position.LAST);
        lst.insert("C",dllist.position.LAST);
	lst.setPosition(dllist.position.PREVIOUS);
	lst.delete();
	assertEquals(true, lst.getItem().equals("C"));
    }
    @Test (expected = Exception.class)
    public void deleteempty(){
	dllist lst = new dllist();
	lst.delete();
    }
}
