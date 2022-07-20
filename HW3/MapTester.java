/**
 * Author - Robin Johnson
 * Verion - 1.0
 * 
 * Discription:
 *             Tester Class to test the assigned methods
 * 			   
 * 				Tests the following methods:
 * 				put(KeyType key, ValueType val)
 * 				get(KeyType key)
 * 				isEmpty()
 * 				makeEmpty
 */
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class MapTester{

	private Map<Integer, Integer> myMap1;
	private Map<Integer, Integer> myMap2;
	private Map<Integer, Integer> testMap;
	
	/**
	 * Method for setting up the enviorment of the tests
	 * 
	 */
	@Before
	public void setUp(){
		myMap1 = new Map<>();
		myMap2 = new Map<>();
		testMap = new Map<>();
	}
	/**
	 * Method for testing Map.put(KeyType key, ValueType val)
	 * 
	 */
	@Test
	public void testPut(){
		myMap1.put(10,5);
		myMap1.put(4, 11);
		testMap.put(10,5);
		testMap.put(4, 11);
		assertNotNull(myMap1);
	}
	/**
	 * Method for testing Map.get(KeyType key)
	 * 
	 */
	@Test
	public void testGet(){
		myMap1.put(1,2);
		testMap.put(1,2);
		assertSame(testMap.get(1),myMap1.get(1));
		

	}
	/**
	 * Method for testing Map.isEmpty()
	 * 
	 */
	@Test
	public void testIsEmpty(){
		assertTrue(myMap2.isEmpty());
	}
	/**
	 * Method for testing Map.makeEmpty()
	 * 
	 */
	@Test
	public void testMakeEmpty(){
		testMap.makeEmpty();
		assertTrue(testMap.isEmpty());
	}
}