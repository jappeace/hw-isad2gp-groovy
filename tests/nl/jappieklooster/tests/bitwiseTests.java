package nl.jappieklooster.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * observes java's bitwise behaviour, which stuff gets modified, and what to assign
 * @author jappie
 *
 */
public class bitwiseTests {

	@Test
	public void and() {
		int i = 4;
		int j = 2;
		int d = i & j;
		Assert.assertEquals(i, 4);
		Assert.assertEquals(j, 2);
		
	}
	@Test
	public void or() {
		int i = 4;
		int j = 2;
		int d = i | j;
		Assert.assertEquals(i, 4);
		Assert.assertEquals(j, 2);
		
	}
	@Test
	public void xor() {
		int i = 4;
		int j = 2;
		int d = i ^ j;
		Assert.assertEquals(i, 4);
		Assert.assertEquals(j, 2);
		
	}
	@Test
	public void leftshift() {
		int i = 4;
		int j = 2;
		int d = i << j;
		Assert.assertEquals(i, 4);
		Assert.assertEquals(j, 2);
		
	}
	@Test
	public void rightshift() {
		int i = 4;
		int j = 2;
		int d = i >> j;
		Assert.assertEquals(i, 4);
		Assert.assertEquals(j, 2);
		
	}
	@Test
	public void negate() {
		int i = 4;
		int d = ~i;
		Assert.assertEquals(i, 4);
		
	}

}
