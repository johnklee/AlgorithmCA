package ds

import java.util.List;

import sort.SortAlgImp

class MinPQ<E> implements IQueue<E>{
	Queue<E> queue = new LinkedList<E>()
	int limitSize=-1
	

	@Override
	public Iterator<E> iterator() {
		return queue.iterator()
	}

	@Override
	public void enqueue(E e) {
		sort(e)
		if(limitSize>0 && queue.size()>limitSize) dequeue()
	}

	@Override
	public E dequeue() {
		return queue.poll()
	}

	@Override
	public boolean isEmpty() {
		return queue.size()==0
	}

	@Override
	public int size() {
		return queue.size()
	}

	protected void sort(E elm)
	{
		int i=0
		for(E e:queue)
		{
			if(e.compareTo(elm)>0)
			{
				break
			}
			i++
		}
		queue.add(i, elm) 
	}
	
	public static void main(args)
	{
		MinPQ<Integer> mpq = new MinPQ<Integer>()
		Random rdm = new Random()
		10.times{
			mpq.enqueue(rdm.nextInt(20))
		}
		while(!mpq.isEmpty())
		{
			printf("%d ", mpq.dequeue())
		}
		println()
	}
}
