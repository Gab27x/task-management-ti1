import java.util.ArrayList;

public class Stack<T> {

	private ArrayList<T> stack;
	private int size;

	public Stack() {
		this.stack=new ArrayList<T>();
		this.size=0;
	}

	/**
	 * 
	 * @param element
	 */
	public void push(T element) {
		stack.add(0,element);
		size++;
	}

	public T pop() {
		T output=stack.get(0);
		stack.remove(0);
		size--;
		return output;

	}

	public T peek() {
		return stack.get(0);
	}

	public boolean isEmpty() {
        return size == 0;
	}

}