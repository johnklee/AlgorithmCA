package sort

import java.util.List;

class BUMergeSort<C> extends MergeSort<C>{

	@Override
	public void sort(List<C> list) {
		int N = list.size()
		for(int i=1; i<N; i=i+i)
		{
			for(int j=0; j<N-i; j+=i+i)
			{
				merge(list, j, j+i-1, Math.min(j+2*i-1, N-1))				
			}
		}
		
	}

	static void main(args)
	{
		def data = ['fifo', 'null', 'left', 'tree', 'loop',
					'next', 'trie', 'sink', 'flip', 'byte',
					'data', 'load', 'exch', 'leaf', 'less', 'path']
		BUMergeSort<String> ss = new BUMergeSort<String>()
		ss.test(data)
	}
}
