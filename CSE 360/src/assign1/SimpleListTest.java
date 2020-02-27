package assign1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleListTest {

	@Test
	public void SimpleListtest() // checks if the object was initialized, this should fail
	{
		SimpleList constructorTest = new SimpleList();
		assertNull(constructorTest);
	}
	
	@Test
	public void SimpleListtest2() // checks if the object was initialized, this shoud pass
	{							  
		SimpleList constructorTest2 = new SimpleList();
		assertNotNull(constructorTest2);
	}
	
	@Test
	public void SimpleListtest3() // checks if the object was initialized, this should fail
	{
		SimpleList constructorTest = new SimpleList();
		assertEquals("", constructorTest.toString());
	}
	
	@Test
	public void testAdd() // tests if the sample array is the same as the result array from the program using the
	{                     //  add method. This should pass
		SimpleList addTest = new SimpleList();
		String arrayTest = "9 3 2 1 0 0 0 0 0 0";
		addTest.add(1);
		addTest.add(2);
		addTest.add(3);
		addTest.add(9);
		assertEquals(arrayTest, addTest.toString());
	}
	
	@Test
	public void testAdd2() //Tests if count was incremented correctly in the add method, this should fail
	{
		SimpleList addTest2 = new SimpleList();
		addTest2.add(1);
		addTest2.add(2);
		addTest2.add(3);
		addTest2.add(9);
		assertNotEquals(4, addTest2.count());
	}
	
	@Test
	public void testRemove() //Tests if remove correctly finds and removes the value and shifts the array
	{                        // This should pass
		String removalArrayTest = "9 3 1 0 0 0 0 0 0 0";
		SimpleList removeTest = new SimpleList();
		removeTest.add(1);
		removeTest.add(2);
		removeTest.add(3);
		removeTest.add(9);
		removeTest.remove(2);
		assertEquals(removalArrayTest, removeTest.toString());
	}
	
	@Test
	public void testRemove2() //Tests if remove correctly updates the value of count
	{                        // This should fail
		SimpleList removeTest2 = new SimpleList();
		removeTest2.add(1);
		removeTest2.add(2);
		removeTest2.add(3);
		removeTest2.add(9);
		removeTest2.remove(2);
		assertNotEquals(3, removeTest2.count());
	}
	
	@Test
	public void testCount() // This is already tested in other tests above, so a basic case will be tested again
	{                       // This should pass
		SimpleList countTest = new SimpleList();
		assertEquals(0, countTest.count());
	}
	
	@Test
	public void testCount2() // This is already tested in other tests above, so a basic case will be tested again
	{                       // This should fail
		SimpleList countTest2 = new SimpleList();
		countTest2.add(1);
		countTest2.add(3);
		assertNotEquals(2, countTest2.count());
	}
	
	@Test
	public void testToString() // This has already been tested in some cases above, so a more basic example
	{                          // will be evaluated. This should pass. It is confirming it returns a string of
		SimpleList stringTest = new SimpleList();  // ten zeros seperated by spaces
		String zeros = "0 0 0 0 0 0 0 0 0 0";
		assertEquals(zeros, stringTest.toString());
	}
	
	@Test
	public void testToString2() // This has already been tested in some cases above, so a more basic example
	{                          // will be evaluated. This should fail. It is confirming it returns a string of
		SimpleList stringTest2 = new SimpleList();  // 2 1 followed by 8 zeros
		String testString = "2 1 0 0 0 0 0 0 0 0";
		stringTest2.add(1);
		stringTest2.add(3);
		stringTest2.add(2);
		stringTest2.remove(3);
		assertNotEquals(testString, stringTest2.toString());
	}
	
	@Test
	public void testSearch() // Tests to see if the correct index is returned for the value of 11 in the array
	{                        // This should pass
		SimpleList searchTest = new SimpleList();
		searchTest.add(5);
		searchTest.add(11);
		searchTest.add(15);
		assertEquals(1, searchTest.search(11));
	}
	
	@Test
	public void testSearch2() // Tests to see if the search method returns -1 if the value is not in the array
	{                        // This should fail
		SimpleList searchTest2 = new SimpleList();
		assertNotEquals(-1, searchTest2.search(2));
	}

}
