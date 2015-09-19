package sort

import java.util.List;

class InsertSort<C> extends SortAlgImp<C>{

	@Override
	public void sort(List<C> list) {
		def cmp = (isAscOrder)?this.&less:this.&large
		for(int i=1; i<list.size(); i++)
		{
			for(int j=i; j>0; j--)
			{
				if(cmp(list[j], list[j-1])) 
				{
					exch(list, j, j-1)
					printList(list)
				}
				else break
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort(C[] list) {
		def cmp = (isAscOrder)?this.&less:this.&large
		for(int i=1; i<list.size(); i++)
		{
			for(int j=i; j>0; j--)
			{
				if(cmp(list[j], list[j-1])) exch(list, j, j-1)
				else break
			}
		}
	}
	
	static void main(args)
	{
		def data = ['fifo', 'null', 'left', 'tree', 'loop',
			        'next', 'trie', 'sink', 'flip', 'byte',
					'data', 'load', 'exch', 'leaf', 'less', 'path']
		InsertSort<String> ss = new InsertSort<String>()
		ss.test(data)
	}
}
