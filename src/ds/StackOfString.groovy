package ds

import java.util.Iterator;

class StackOfString implements IStack<String>{
	Stack st = new Stack()
	
	class SIter implements Iterator<String>
	{
		Stack ist = new Stack()
		
		public SIter(Stack st)
		{
			ist.addAll(st)
		}
		
		@Override
		public boolean hasNext() {
			return !ist.isEmpty()
		}

		@Override
		public String next() {
			return ist.pop()
		}

		@Override
		public void remove() {
			throw new java.lang.Exception("Not Support!")				
		}		
	}

	@Override
	public void push(String e) {
		st.push(e)	
	}

	@Override
	public String pop() {
		return st.pop()
	}

	@Override
	public boolean isEmpty() {
		return st.isEmpty()
	}

	@Override
	public int size() {
		return st.size()
	}

	public def operate(String str)
	{
		def pops = []
		for(String e:str.split(' '))
		{			
			if(e.equals("-")) pops.add(st.pop())
			else st.push(e)
		}
		return pops
	}
	
	@Override
	public Iterator<String> iterator() {
		return new SIter(st)
	}
}
