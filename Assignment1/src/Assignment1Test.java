import static org.junit.Assert.fail;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class Assignment1Test {

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckInput() {
		
	}

	@Test
	public void testToStringList() {
		String[] str = Assignment1.toStringList("1 2 3");
		String[] str1 = {"1", "2", "3"};
		for(int x = 0; x<str.length; x++){
			Assert.assertEquals(str1[x], str[x]);
		}
	}

	@Test
	public void testArrangeArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFactor() {
		fail("Not yet implemented");
	}

	@Test
	public void testCgf() {
		ArrayList<Integer> list = new ArrayList<Integer>(0);
		list.add(1);
		list.add(2);
		list.add(3);
		int cgf1 = Assignment1.cgf(list);
		int cgf2 = 1;
		Assert.assertEquals(cgf2, cgf1);
	}

	@Test
	public void testToStringIntArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsInteger() {
		fail("Not yet implemented");
	}

}
