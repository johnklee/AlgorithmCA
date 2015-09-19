package ds;

public interface IStack<E> extends Iterable<E>{
	public void push(E e);
	public E pop();
	public boolean isEmpty();
	public int size();
}
