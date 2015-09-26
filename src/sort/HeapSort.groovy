package sort

import java.util.List;

class HeapSort<C> extends SortAlgImp<C>{

	@Override
	public void sort(List<C> list) {
		/* 0) Building heap*/
		int N = list.size()		
		for(int k=N/2; k>=1; k--)
		{
			sink(k, N, list)
		}
			
		/* 1) Sorint*/
		while(N>0)
		{
			N--
			exch(list, 0, N)
			sink(1, N, list)
		}
	}

	private void sink(int k, int N, List<C> a)
	{
		while(2*k<=N)
		{			
			int j = 2*k			
			if(j<N && cmp(a[j-1], a[j])) j++			
			if(!cmp(a[k-1], a[j-1])) break
			exch(a, k-1, j-1)
			k=j
		}
	}
	
	static void main(args)
	{
		def data = [76, 94, 28, 83, 39, 64, 35, 71, 30, 81, 69, 21]
		HeapSort<Integer> ss = new HeapSort<Integer>()
		ss.test(data)
	}
}
