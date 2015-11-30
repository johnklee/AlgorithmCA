package sort

import java.util.List;

/**
 * Source - https://class.coursera.org/algs4partII-006/lecture/30
 */
class LSDSortInt<Integer> extends SortAlgImp<Integer> {
	static HashMap<String,Integer> IntCharMap = new HashMap<String,Integer>()
	static{
		'0123456789'.each{ c->
			IntCharMap.put(c, java.lang.Integer.valueOf(c))			
		}
	}
	
	int intAt(int val, d)
	{
		String strVal = String.valueOf(val)
		if(strVal.length()-1>=d) return IntCharMap[strVal[-(d+1)]]
		else return 0
	}
	
	void sort(List<String> list, int s, int e, int mlen)
	{
		def radixMap = [:].withDefault { k-> return []}
		def slist = []; slist.addAll(list) 
		mlen.times { i->
			slist.each{ v->
				radixMap[intAt(v, i)].add(v)
			}
			slist.clear()
			10.times{
				radixMap[it].each{v->slist.add(v)}
			}
			radixMap.clear()
		}
		list.clear(); list.addAll(slist)
	}
	
	@Override
	public void sort(List<String> list) {
		int mlen=0
		
		// Find the longest length -> mlen
		list.each{if(String.valueOf(it).length()>mlen) mlen=String.valueOf(it).length()}
		
		// Start sorting from least significant digit
		sort(list, 0, list.size()-1, mlen)		
	}

	static void main(args)
	{
		def data = [76, 94, 28, 83, 39, 64, 35, 71, 30, 81, 69, 21]
		LSDSortInt lsdSort = new LSDSortInt()
		lsdSort.test(data)
	}
}
