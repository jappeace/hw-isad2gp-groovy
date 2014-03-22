package nl.jappieklooster.tests.ISAD2;

import static org.junit.Assert.*;

import nl.jappieklooster.list.SkipList
import org.junit.Test;

class SkipLists {

	SkipList<Integer> testList;
	
	void resetTestList(){
		
		testList = new SkipList<Integer>();
		testList.add(4)
		testList.add(9)
		testList.add(1)
		testList.add(3)
		testList.add(4)
		testList.add(10)
		testList.add(324)
		testList.add(-4)
		testList.add(-34)
		testList.add(-24)
		testList.add(-14)
		testList.add(-40)
		testList.add(30)
		testList.add(39)
		testList.add(12)
		testList.add(3)
		testList.add(1)
		testList.add(3)
		testList.add(89)
		testList.add(90932)
		
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
