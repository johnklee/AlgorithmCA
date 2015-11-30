package sort

import java.util.List;

/**
 * Source - https://class.coursera.org/algs4partII-006/lecture/31
 */
class MSDSort <String> extends SortAlgImp<String>{

	@Override
	public void sort(List<String> list) {
		// TODO Auto-generated method stub
		
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
