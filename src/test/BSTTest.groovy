package test;

import static org.junit.Assert.*

import org.junit.Test

import ds.BST

class BSTTest {

	@Test
	public void test() {
		HashMap<Integer,Integer> map = new HashMap<String,Integer>()
		BST<Integer,Integer> bst = new BST<String,Integer>()
		for(int i=0; i<24; i+=2)
		{			
			map.put(i, i)
			bst.put(i, i);
		}
				
		assertTrue(bst.ceiling(3)==4)		
		assertTrue(bst.floor(9)==8)
		
		for(Integer k:map.keySet())
		{
			assertTrue(map.get(k).equals(bst.get(k)))
		}
		printf("Done!")
	}
}
