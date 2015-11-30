package ds

class HeapPQ<E extends Comparable> {
	int N=0, c=10
	def a = null
	
	public HeapPQ(int capacity)
	{
		c = capacity
		a = new E[c+2]
	}
	
	private void swim(int k)
	{
		while(k>1 && less(a[(int)k/2], a[(int)k]))
		{
			exch((int)k/2, (int)k)
			k/=2
		}
	}
	
	private void sink(int k)
	{
		while(2*k<=N)
		{
			int j = 2*k
			if(j<N && less(a[j], a[j+1])) j++
			if(!less(a[k], a[j])) break
			exch(k, j)
			k=j
		}
	}
	
	public E del()
	{
		if(N==0) return null
		E e = a[1]
		exch(1, N--)
		sink(1)
		a[N+1]=null
		return e
	}
	
	public void insert(E e)
	{		
		a[++N]=e
		swim(N)
		if(N>c) 
		{
			del()
			N--	
		}	
	}
	
	public boolean isEmpty(){return N==0}
	
	public boolean less(E c1, E c2)
	{
		return (c1.compareTo(c2))<0
	}
	
	public void exch(int i1, int i2)
	{
		E t=a[i1]
		a[i1]=a[i2]
		a[i2]=t
	}
	
	static void main(arg)
	{
		HeapPQ<Integer> hpq = new HeapPQ<Integer>(10)
		Random rdm = new Random()
		10.times{
			hpq.insert(rdm.nextInt(20))
		}
		while(!hpq.isEmpty())
		{
			printf("%d ", hpq.del())
		}
		println()
	}
}
