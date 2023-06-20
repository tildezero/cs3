import junit.framework.*; 
import java.util.*;

public class Lab23Tester extends TestCase
{	
	public void testfind()
	{
		TNode<String> anakin = new TNode<String>("Anakin");
		
		TNode<String> luke = new TNode<String>("Luke");
		TNode<String> leia = new TNode<String>("Leia");
		TNode<String> ben = new TNode<String>("Ben");
		TNode<String> tom = new TNode<String>("Tom Brady");
		TNode<String> bill = new TNode<String>("Bill Belichick");
		
		anakin.addChild(luke);
		anakin.addChild(leia);
		leia.addChild(ben);
		luke.addChild(tom);
		luke.addChild(bill);
		
		TNode<String> found = RoyalFamily.find(anakin, "Ben");
		assertEquals("find does not return the correct node (Ben)", ben, found);
		
		found = RoyalFamily.find(anakin, "Leia");
		assertEquals("find does not return the correct node (Leia)", leia, found);
		
		found = RoyalFamily.find(anakin, "Luke");
		assertEquals("find does not return the correct node (Luke)", luke, found);
		
		found = RoyalFamily.find(anakin, "Anakin");
		assertEquals("find does not return the correct node (Anakin)", anakin, found);
		
		found = RoyalFamily.find(leia, "Ben");
		assertEquals("find does not return the correct node (Ben) from (Leia)", ben, found);
		
		found = RoyalFamily.find(luke, "Ben");
		assertEquals("find does not return the correct node (null) from (Luke) when looking for (Ben)", null, found);
		
		found = RoyalFamily.find(luke, "Leia");
		assertEquals("find does not return the correct node (null) from (Luke) when looking for (Leia)", null, found);
		
		found = RoyalFamily.find(luke, "Anakin");
		assertEquals("find does not return the correct node (null) from (Luke) when looking for (Anakin)", null, found);
		
		found = RoyalFamily.find(anakin, "Tom Brady");
		assertEquals("find does not return the correct node (Tom Brady)", tom, found);
		
		found = RoyalFamily.find(anakin, "Bill Belichick");
		assertEquals("find does not return the correct node (Bill Belichick)", bill, found);
	}
	
	public void testGetPath()
	{
		TNode<String> anakin = new TNode<String>("Anakin");
		
		TNode<String> luke = new TNode<String>("Luke");
		TNode<String> leia = new TNode<String>("Leia");
		TNode<String> ben = new TNode<String>("Ben");
		
		TNode<String> tom = new TNode<String>("Tom Brady");
		TNode<String> bill = new TNode<String>("Bill Belichick");
		
		anakin.addChild(luke);
		anakin.addChild(leia);
		leia.addChild(ben);
		
		luke.addChild(tom);
		luke.addChild(bill);
		
		String path = RoyalFamily.getPath(ben);
		assertEquals("Incorrect path from (Ben)", "[Anakin -> Leia -> Ben]", "[" + path + "]");
		
		path = RoyalFamily.getPath(leia);
		assertEquals("Incorrect path from (Leia)", "[Anakin -> Leia]", "[" + path + "]");
		
		path = RoyalFamily.getPath(luke);
		assertEquals("Incorrect path from (Luke)", "[Anakin -> Luke]", "[" + path + "]");
		
		path = RoyalFamily.getPath(anakin);
		assertEquals("Incorrect path from (Anakin)", "[Anakin]", "[" + path + "]");
		
		path = RoyalFamily.getPath(tom);
		assertEquals("Incorrect path from (Luke)", "[Anakin -> Luke -> Tom Brady]", "[" + path + "]");
		
		path = RoyalFamily.getPath(bill);
		assertEquals("Incorrect path from (Luke)", "[Anakin -> Luke -> Bill Belichick]", "[" + path + "]");
	}

}