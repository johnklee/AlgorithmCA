package sort

import java.util.List;

class QuickSort<C> extends SortAlgImp<C>{
	private int partition(List<C> list, s, e)
	{
		int i=s, j=e+1
		while(true)
		{
			while(cmp(list[++i], list[s]))
				if(i==e) break
			while(cmp(list[s], list[--j]))
				if(j==s) break
			
			if(i>=j) break
			else exch(list, i, j)
		}
		exch(list, s, j)
		return j
	}
	
	void sort(List<C> list, int s, int e)
	{
		if(e<=s) return
		int j = partition(list, s, e)
		sort(list, s, j-1)
		sort(list, j+1, e)
 	}

	@Override
	public void sort(List<C> list) {
		Collections.shuffle(list)
		sort(list, 0, list.size()-1)
	}
	
	static void main(args)
	{
		def data = [76, 94, 28, 83, 39, 64, 35, 71, 30, 81, 69, 21]
		QuickSort<Integer> ss = new QuickSort<Integer>()
		ss.test(data)
	}
}
