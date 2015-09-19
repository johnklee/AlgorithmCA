package sort

import java.util.List;

class QuickSort3W<C> extends QuickSort<C>{

	@Override
	void sort(List<C> list, int s, int e)
	{
		if(s>=e) return
		int lt=s, gt=e, i=s
		C v = list[s]
		while(i<=gt)
		{
			int c = cmpr(list[i], v)
			if(c<0) exch(list, i++, lt++)
			else if(c>0) exch(list, i, gt--)
			else i++
		}
		
		sort(list, s, lt-1)
		sort(list, gt+1, e)
	}
	
	static void main(args)
	{
		def data = ['HOLE', 'KISS', 'TACO', 'BUSH', 'NENA', 'RUSH', 'MIMS', 'PINK', 'DIDO', 'SADE', 'ACDC', 'CAKE']
		QuickSort3W<String> ss = new QuickSort3W<String>()
		ss.test(data)
	}
}
