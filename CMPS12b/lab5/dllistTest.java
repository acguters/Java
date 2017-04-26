// dllistTest.java
// Unit tests for dllist

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class dllistTest {

  @Test
  public void startsEmptyTest() {
    dllist lst = new dllist();
    assertEquals(true, lst.isEmpty());
  }

  @Test
  public void notEmptyTest() {
    dllist lst = new dllist();
    lst.insert("Testing", dllist.position.LAST);
    assertEquals(false, lst.isEmpty());
  }
  
  @Test
  public void getItemTest(){
    dllist lst = new dllist();
    lst.insert("First", dllist.position.FIRST);
    assertEquals("First", lst.getItem());
    lst.insert("Still Testing!", dllist.position.LAST);
    assertEquals("Still Testing!", lst.getItem());
    lst.insert("Previous", dllist.position.PREVIOUS);
    assertEquals("Previous", lst.getItem());
    lst.insert("Next", dllist.position.FOLLOWING);
    assertEquals("Next", lst.getItem());
  }
  
  @Test
  public void doubleInsertTest(){
    dllist list = new dllist();
    list.insert("Hi, Happy Halloween!", dllist.position.FIRST);
    list.insert("Thanks!", dllist.position.FOLLOWING);
    assertEquals("Thanks!", list.getItem());
  }
  
  @Test
  public void setPositionFirstTest(){
    dllist list = new dllist();
    list.insert("One", dllist.position.LAST);
    list.insert("Two", dllist.position.LAST);
    list.setPosition(dllist.position.FIRST);
    assertEquals("One", list.getItem());
  }
  
  @Test
  public void insertListLastTest(){
    dllist list = new dllist();
    list.insert("A", dllist.position.LAST);
    list.insert("B", dllist.position.LAST);
    list.insert("C", dllist.position.LAST);
    list.insert("D", dllist.position.PREVIOUS);
    list.setPosition(dllist.position.LAST);
    assertEquals("C", list.getItem());
  }
  
  @Test
  public void insertListFirstTest(){
    dllist list = new dllist();
    list.insert("A", dllist.position.FIRST);
    list.insert("B", dllist.position.FIRST);
    list.insert("C", dllist.position.FIRST);
    list.insert("D", dllist.position.FOLLOWING);
    list.setPosition(dllist.position.FIRST);
    assertEquals("C", list.getItem());
  }
  
  @Test
  public void previousTest(){
    dllist list = new dllist();
    list.insert("One", dllist.position.LAST);
    list.insert("2", dllist.position.LAST);
    list.insert("Three", dllist.position.LAST);
    list.insert("Hi", dllist.position.PREVIOUS);
    
    list.setPosition(dllist.position.LAST);
    assertEquals("Three", list.getItem());
    
    list.setPosition(dllist.position.PREVIOUS);
    assertEquals("Hi", list.getItem());
    
    list.setPosition(dllist.position.PREVIOUS);
    assertEquals("2", list.getItem());
    
    list.setPosition(dllist.position.PREVIOUS);
    assertEquals("One", list.getItem());
  }
  
  @Test
  public void followingTest(){
    dllist list = new dllist();
    list.insert("One", dllist.position.FIRST);
    list.insert("2", dllist.position.FIRST);
    list.insert("Three", dllist.position.FIRST);
    list.insert("Hi", dllist.position.FOLLOWING);
    
    list.setPosition(dllist.position.FIRST);
    assertEquals("Three", list.getItem());
    
    list.setPosition(dllist.position.FOLLOWING);
    assertEquals("Hi", list.getItem());
    
    list.setPosition(dllist.position.FOLLOWING);
    assertEquals("2", list.getItem());
    
    list.setPosition(dllist.position.FOLLOWING);
    assertEquals("One", list.getItem());    
  }
  
  @Test
  public void randomPositionTest(){
    dllist list = new dllist();
    
    list.insert("Pull", dllist.position.LAST);
    list.insert("My Finger", dllist.position.FOLLOWING);
    list.setPosition(dllist.position.FIRST);
    list.insert("Tuba", dllist.position.PREVIOUS);
    list.insert("Cat", dllist.position.FIRST);
    list.insert("Rainbows", dllist.position.PREVIOUS);
    
    assertEquals("Rainbows", list.getItem());
    list.setPosition(dllist.position.FOLLOWING);
    assertEquals("Cat", list.getItem());
    list.setPosition(dllist.position.LAST);
    assertEquals("My Finger", list.getItem());
    list.setPosition(dllist.position.PREVIOUS);
    list.setPosition(dllist.position.PREVIOUS);
    assertEquals("Tuba", list.getItem());
    list.setPosition(dllist.position.FOLLOWING);
    assertEquals("Pull", list.getItem());
  }
  
  @Test
  public void getPositionTest(){
    dllist list = new dllist();
    list.insert("Pull", dllist.position.LAST);
    list.insert("My Finger", dllist.position.FOLLOWING);
    list.setPosition(dllist.position.FIRST);
    list.insert("Tuba", dllist.position.PREVIOUS);
    list.insert("Cat", dllist.position.FIRST);
    list.insert("Rainbows", dllist.position.PREVIOUS);
    
    assertEquals(0, list.getPosition());
    list.setPosition(dllist.position.FOLLOWING);
    assertEquals(1, list.getPosition());
    list.setPosition(dllist.position.LAST);
    assertEquals(4, list.getPosition());
    list.setPosition(dllist.position.PREVIOUS);
    list.setPosition(dllist.position.PREVIOUS);
    assertEquals(2, list.getPosition());
    list.setPosition(dllist.position.FOLLOWING);
    assertEquals(3, list.getPosition());
  }
  
  @Test
  public void deleteFirstTest(){
    dllist list = new dllist();
    
    list.insert("Spoopy", dllist.position.FIRST);
    list.insert("Chameleon", dllist.position.FIRST);
    list.insert("Merry Christmas", dllist.position.LAST);
    list.insert("Oysters", dllist.position.PREVIOUS);
    
    list.setPosition(dllist.position.FIRST);
    list.delete();
    assertEquals("Spoopy", list.getItem());
  }
  
  @Test
  public void deleteMiddleTest(){
    dllist list = new dllist();
    
    list.insert("Spoopy", dllist.position.FIRST);
    list.insert("Chameleon", dllist.position.FIRST);
    list.insert("Merry Christmas", dllist.position.LAST);
    list.insert("Oysters", dllist.position.PREVIOUS);
    
    list.setPosition(dllist.position.FIRST);
    list.setPosition(dllist.position.FOLLOWING);
    list.delete();
    assertEquals("Oysters", list.getItem());
  }
  
  @Test
  public void deleteLastTest(){
    dllist list = new dllist();
    
    list.insert("Spoopy", dllist.position.FIRST);
    list.insert("Chameleon", dllist.position.FIRST);
    list.insert("Merry Christmas", dllist.position.LAST);
    list.insert("Oysters", dllist.position.PREVIOUS);
    
    list.setPosition(dllist.position.LAST);
    list.delete();
    assertEquals("Oysters", list.getItem());
  }
  
  @Test
  public void deleteMiddlePositionTest(){
    dllist list = new dllist();
    
    list.insert("Spoopy", dllist.position.FIRST);
    list.insert("Chameleon", dllist.position.FIRST);
    list.insert("Merry Christmas", dllist.position.LAST);
    list.insert("Oysters", dllist.position.PREVIOUS);
    
    list.setPosition(dllist.position.FIRST);
    list.setPosition(dllist.position.FOLLOWING);
    list.delete();
    
    list.setPosition(dllist.position.FIRST);
    assertEquals(0, list.getPosition());
    list.setPosition(dllist.position.FOLLOWING);
    assertEquals(1, list.getPosition());
    list.setPosition(dllist.position.LAST);
    assertEquals(2, list.getPosition());
  }
  
  @Test
  public void deleteFirstPositionTest(){
    dllist list = new dllist();
    
    list.insert("Spoopy", dllist.position.FIRST);
    list.insert("Chameleon", dllist.position.FIRST);
    list.insert("Merry Christmas", dllist.position.LAST);
    list.insert("Oysters", dllist.position.PREVIOUS);
    
    list.setPosition(dllist.position.FIRST);
    list.delete();
    
    assertEquals(0, list.getPosition());
    list.setPosition(dllist.position.FOLLOWING);
    assertEquals(1, list.getPosition());
    list.setPosition(dllist.position.LAST);
    assertEquals(2, list.getPosition());
  }
  
  @Test
  public void deleteLastPositionTest(){
    dllist list = new dllist();
    
    list.insert("Spoopy", dllist.position.FIRST);
    list.insert("Chameleon", dllist.position.FIRST);
    list.insert("Merry Christmas", dllist.position.LAST);
    list.insert("Oysters", dllist.position.PREVIOUS);
    
    list.setPosition(dllist.position.LAST);
    list.delete();
    
    list.setPosition(dllist.position.FIRST);
    assertEquals(0, list.getPosition());
    list.setPosition(dllist.position.FOLLOWING);
    assertEquals(1, list.getPosition());
    list.setPosition(dllist.position.LAST);
    assertEquals(2, list.getPosition());
  }
 
   @Test
  public void setPositionErrorTest(){
    dllist list = new dllist();
    
    list.setPosition(dllist.position.PREVIOUS);
    list.insert("Cereal", dllist.position.FIRST);
    list.setPosition(dllist.position.PREVIOUS);
    assertEquals(0, list.getPosition());
    
    list.insert("Waffles", dllist.position.LAST);
    list.setPosition(dllist.position.FOLLOWING);
    assertEquals(1, list.getPosition());
  }
  
  @Test (expected=Exception.class)
  public void getItemErrorTest(){
    dllist list = new dllist();
    
    list.getItem();
    
  }
  
  @Test (expected=Exception.class)
  public void deleteErrorTest(){
    dllist list = new dllist();
    
    list.delete();
  }
  
  /*@Test (expected=Exception.class)
  public void insertErrorTest(){
    dllist list = new dllist();
    
    list.insert("FAIL!!!!", (dllist.position)list );
  }*/
  
  @Test
  public void insertFollowingTest(){
    dllist list = new dllist();
    
    list.insert("A", dllist.position.FOLLOWING);
    list.insert("B", dllist.position.FOLLOWING);
    assertEquals("B", list.getItem());
  }
  
  @Test
  public void insertPreviousTest(){
    dllist list = new dllist();
    
    list.insert("A", dllist.position.PREVIOUS);
    list.insert("B", dllist.position.PREVIOUS);
    assertEquals("B", list.getItem());
  }
  
  
}
