package sort

import java.util.List;

abstract class SortAlgImp<C> implements ISortAlg<C>{
	boolean isAscOrder=true
	def 	cmp = (isAscOrder)?this.&less:this.&large
	
	public void printList(List<C> data){printList(data, 0, data.size()-1)}
	public void printList(List<C> data, int s, int e)
	{
		(s..e).each{ i->
			printf("%s ", data[i])
		}
		println()
	}
	
	@Override
	public void asc() {
		isAscOrder=true
		cmp = (isAscOrder)?this.&less:this.&large
	}

	@Override
	public void des() {
		isAscOrder=false
		cmp = (isAscOrder)?this.&less:this.&large		
	}
	
	@Override
	public boolean isSorted(List<C> list, C s, C e)
	{
		int t=0
		(s..e).each{
			int p = s.compareTo(e)
			if(p!=0 && t==0) t = p
			else if(t!=0 && p!=t) return false
		}
		return true
	}
	
	public int cmpr(C c1, C c2)
	{
		int t = c1.compareTo(c2)
		if(!isAscOrder) t*=-1
		return t
	}
	
	public int cmpr(List<C> list, int i, int j)
	{
		return cmpr(list[i], list[j])
	}
	
	public boolean less(C c1, C c2, Comparator<C> cmp)
	{		
		return (cmp.compare(c1, c2)<0)
	}
	
	public boolean large(C c1, C c2, Comparator<C> cmp)
	{
		return (cmp.compare(c1, c2)>0)
	}
	
	public boolean less(C c1, C c2)
	{
		return (c1.compareTo(c2))<0
	}
	
	public boolean large(C c1, C c2)
	{
		return (c1.compareTo(c2))>0
	}
	
	public void exch(C[] ary, int i1, int i2)
	{
		C t=ary[i1]
		ary[i1]=ary[i2]
		ary[i2]=t
	}
	
	public void exch(List<C> list, int i1, int i2)
	{
		C t = list[i1]
		list[i1]=list[i2]
		list[i2]=t
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void sort(C[] array) {
		throw new java.lang.UnsupportedOperationException();		
	}
	
	public void test(List<C> data)
	{			
		printf("\t[Info] Before sort:\t")
		data.each{ e->
			printf("%s ", e)
		}
		println()		
		sort(data)
		printf("\t[Info] After sort:\t")
		data.each{ e->
			printf("%s ", e)
		}
		println()
	}
}
