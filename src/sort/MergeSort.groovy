package sort

import java.util.List;

class MergeSort<C> extends SortAlgImp<C>{
	boolean bDebug=false
	static int CUTOFF = 7	

	protected void merge(List<C> list, int s, int m, int e)
	{				
		assert isSorted(list, s, m)
		assert isSorted(list, m+1, e)
		def aux = []; aux.addAll(list)	
		
		int i=s; int j=m+1
		(s..e).each{
			if(i>m) list[it]=aux[j++]
			else if(j>e) list[it]=aux[i++] 
			else if(cmp(aux[i], aux[j])) list[it]=aux[i++]
			else list[it]=aux[j++]
		}		
		assert isSorted(list, s, e)
		if(bDebug) printf("Merge: "); printList(list)
	}
	
	public void sort(List<C> list, int s, int e)
	{
		
		if(e<=s) return
		int m = s+(e-s)/2
		sort(list, s, m)
		sort(list, m+1, e)
		if(cmp(list[m], list[m+1])) return
		merge(list, s, m ,e)
	}
	
	@Override
	public void sort(List<C> list) {
		if(list.size() < CUTOFF)
		{
			new InsertSort().sort(list)
			return
		}
		sort(list, 0, list.size()-1)
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort(C[] array) {
		throw new java.lang.UnsupportedOperationException();
	}
	
	static void main(args)
	{
		def data = ['HOLE', 'KISS', 'TACO', 'BUSH', 'NENA', 'RUSH', 'MIMS', 'PINK', 'DIDO', 'SADE', 'ACDC', 'CAKE']
		MergeSort<Integer> ss = new MergeSort<Integer>(bDebug:true)
		ss.test(data)
	}
}
