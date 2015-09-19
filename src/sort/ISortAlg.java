package sort;

import java.util.List;

public interface ISortAlg<C> {
	public boolean isSorted(List<C> list, C s, C e);
	public void sort(List<C> list);
	public void sort(C[] array);
	public void asc();
	public void des();
}
