package sort

import java.util.List;

class SelectionSort<C> extends SortAlgImp<C>{				
	public void sort(List<C> list)
	{
		for(int i=0; i<list.size()-1; i++)
		{
			int si = i			
			for(int j=i+1; j<list.size(); j++)
			{
				if(cmp(list[si], list[j])) 
				{					
					si=j
				}
			}	
			if(si!=i)
			{
				exch(list, i, si)
				printList(list)
			}								
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void sort(C[] array)
	{
		def cmp = (isAscOrder)?this.&large:this.&less
		for(int i=0; i<list.size()-1; i++)
		{
			int si = i
			for(int j=i+1; j<list.size(); j++)
			{
				if(cmp(array[si], array[j])) si=j
			}
			exch(array, i, si)
		}
	}
	
	static void main(args)
	{
		def data = ['fifo', 'null', 'left', 'tree', 'loop',
			        'next', 'trie', 'sink', 'flip', 'byte',
					'data', 'load', 'exch', 'leaf', 'less', 'path']
		SelectionSort<String> ss = new SelectionSort<String>()
		ss.test(data)
	}
}
