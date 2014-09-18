import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class Assignment1Test {
	@Test
	public void testCheckInput() {
		Assert.assertEquals(true, Assignment1.checkInput("notQuit"));
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
		String[] str = {"1", "2", "3"};
		ArrayList<Integer> list1 = Assignment1.arrangeArray(str);
		ArrayList<Integer> list2 = new ArrayList<Integer>(0);
		list2.add(1);
		list2.add(2);
		list2.add(3);
		Assert.assertEquals(list2, list1);
	}

	@Test
	public void testFactor() {
		String str1 = Assignment1.toString(Assignment1.factor(5));
		String str2 = "[1, 5]";
		Assert.assertEquals(str2, str1);
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
		int[] list = {1, 2, 3};
		String output = "[1, 2, 3]";
		Assert.assertEquals(output, Assignment1.toString(list));
	}

	@Test
	public void testIsInteger() {
		Assert.assertEquals(true, Assignment1.isInteger("1"));
	}

}
