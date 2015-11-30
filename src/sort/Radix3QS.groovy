package sort

import java.util.List;


/**
 * Source - https://class.coursera.org/algs4partII-006/lecture/32
 * @author John
 *
 */
class Radix3QS<String> extends SortAlgImp<String>{

	int charAt(String str, d)
	{
		if(d>=str.size()) return -1
		else return str.charAt(d)		
	}
	
	void sort(List<String> list, int lo, int hi, int d)
	{
		if(hi <= lo) return
		int lt = lo, gt = hi
		int v = charAt(list[lo], d)
		int i = lo+1
		// ===== Initialization =====
		//   lo                   hi
		//   |                    |
		// [ v1, v2, v3, v4, ..., vn ]
		//   |   |                |
		//   lt  i                gt
		while(i<=gt)
		{
			int t = charAt(list[i], d)
			if		(t < v) exch(list, lt++, i++)
			else if	(t > v) exch(list, gt--, i)
			else i++
		}
		
		sort(list, lo, lt-1, d)
		if(v >= 0) sort(list, lt, gt, d+1) 
		sort(list, gt+1, hi, d)
	}
	
	@Override
	public void sort(List<String> list) {
		sort(list, 0, list.size()-1, 0)		
	}
	
	static void main(args)
	{
		def data = ["John", "Joseph", "Ken", "Mary", "Peter", "johnson", 
					"Tim", "Tom", "Anderson", "Andy", "Bob", "Forry", 
					"Carter", "Derek"]
		Radix3QS ss = new Radix3QS()
		ss.test(data)
	}
}
