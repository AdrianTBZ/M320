package V1_SeriesB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {

	private MyList<String> myList;

	@BeforeEach
	public void setUp() {
		myList = new MyList<>();
	}

	@Test
	public void testAddElement() {
		assertTrue(myList.add("Element"));
		assertEquals(1, myList.size());
		assertEquals("Element", myList.get(0));
	}

	@Test
	public void testRemoveElement() {
		myList.add("Element1");
		myList.add("Element2");
		String removedElement = myList.remove(0);
		assertEquals("Element1", removedElement);
		assertEquals(1, myList.size());
		assertEquals("Element2", myList.get(0));
	}

	@Test
	public void testClear() {
		myList.add("Element1");
		myList.add("Element2");
		myList.clear();
		assertEquals(0, myList.size());
	}

	@Test
	public void testIndexOf() {
		myList.add("Element1");
		myList.add("Element2");
		assertEquals(0, myList.indexOf("Element1"));
		assertEquals(1, myList.indexOf("Element2"));
	}
}
