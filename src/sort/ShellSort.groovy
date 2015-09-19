package sort

import java.util.List;

class ShellSort<C> extends SortAlgImp<C>{	

	@Override
	public void sort(List<C> list) {		
		int N = list.size()
		int h = 1
		while(h<N/3) h = 3*h+1
		
		while(h>=1)
		{
			for(int i=h; i<N; i++)
			{
				for(int j=i; j>=h && cmp(list[j], list[j-h]); j-=h)
					exch(list, j, j-h)				
			}
			h=h/3
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort(C[] list) {
		def cmp = (isAscOrder)?this.&less:this.&large
		int N = list.size()
		int h = 1
		while(h>N/3) h = 3*h+1
		
		while(h>=1)
		{
			for(int i=h; i<N; i++)
			{
				for(int j=i-1; j>h && cmp(list[i], list[j]); j-=h)
					exch(list, i, j)				
			}
			h=h/3
		}		
	}

	static void main(args)
	{
		def data = [1,3,5,6,4,9,7,2,8]
		ShellSort<Integer> ss = new ShellSort<Integer>()
		ss.isAscOrder=false
		ss.test(data)
	}
}
