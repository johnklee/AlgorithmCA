package ds

import java.util.Iterator;

class QueueOfString implements IQueue<String>{
	Queue<String> queue = new LinkedList<String>()

	class QIter implements Iterator<String>
	{
		Queue<String> iq = new LinkedList<String>()
		
		public QIter(Queue<String> queue)
		{
			iq.addAll(queue)
		}
		
		@Override
		public boolean hasNext() {
			!iq.isEmpty()
		}

		@Override
		public String next() {
			return iq.poll()
		}

		@Override
		public void remove() {
			throw new java.lang.Exception("Not Support!")			
		}	
	}
	
	@Override
	public void enqueue(String e) {
		queue.add(e)		
	}

	@Override
	public String dequeue() {
		queue.poll()
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty()
	}

	@Override
	public int size() {
		return queue.size()
	}
	
	public def operate(String str)
	{
		def pops = []
		for(String e:str.split(' '))
		{
			if(e.equals("-")) pops.add(dequeue())
			else enqueue(e)
		}
		return pops
	}

	@Override
	public Iterator<String> iterator() {
		return new QIter(queue)
	}
}
