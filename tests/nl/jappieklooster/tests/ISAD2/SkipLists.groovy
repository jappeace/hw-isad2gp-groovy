package nl.jappieklooster.tests.ISAD2;

import static org.junit.Assert.*;

import nl.jappieklooster.list.SkipList
import org.junit.Test;

class SkipLists {

	SkipList<Integer> testList;
	
	private void resetTestList(){
		
		testList = new SkipList<Integer>()
		testList.add((Integer)4)
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
	public void iterationOrder() {
        List<Integer> expectedOrder = new ArrayList<>()
		expectedOrder.add(-40)
		expectedOrder.add(-34)
		expectedOrder.add(-24)
		expectedOrder.add(-14)
		expectedOrder.add(-4)
		expectedOrder.add(1)
		expectedOrder.add(1)
		expectedOrder.add(3)
		expectedOrder.add(3)
		expectedOrder.add(3)
		expectedOrder.add(4)
		expectedOrder.add(4)
		expectedOrder.add(9)
		expectedOrder.add(10)
		expectedOrder.add(12)
		expectedOrder.add(30)
		expectedOrder.add(39)
		expectedOrder.add(89)
		expectedOrder.add(324)
		expectedOrder.add(90932)
		resetTestList();
		testList.eachWithIndex{ Integer value, int index ->
            assertEquals(expectedOrder[index], value)
		}
	}

}
