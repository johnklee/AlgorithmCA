package uf;

import static org.junit.Assert.*;

import org.junit.Test;

class UFTest {
	@Test
	public void testQF() {
		QuickFind qf = new QuickFind(10)
		qf.union(0, 1)
		assertTrue(qf.connected(0, 1))
		qf.union(0, 3)
		assertTrue(qf.connected(1, 3))
		assertTrue(!qf.connected(2, 3))
	}

	
	@Test
	public void testQU() {
		QuickUnion qf = new QuickUnion(10)
		qf.union(0, 1)
		assertTrue(qf.connected(0, 1))
		qf.union(0, 3)
		assertTrue(qf.connected(1, 3))
		assertTrue(!qf.connected(2, 3))
	}
	
	@Test
	public void testWQU() {
		WQuickUnion qf = new WQuickUnion(10)
		qf.union(0, 1)
		assertTrue(qf.connected(0, 1))
		qf.union(0, 3)
		assertTrue(qf.connected(1, 3))
		assertTrue(!qf.connected(2, 3))
	}
	
	@Test
	public void testWQUPC() {
		WQUPC qf = new WQUPC(10)
		qf.union(0, 1)
		assertTrue(qf.connected(0, 1))
		qf.union(0, 3)
		assertTrue(qf.connected(1, 3))
		assertTrue(!qf.connected(2, 3))
	}
}
