
package model;
public class Stack<T> {

	private StackNode<T> top;
	private int size;

	public Stack() {
		this.top=null;
		this.size=0;
	}

	/**
	 * 
	 * @param element
	 */
	public void push(T element) {
		StackNode<T> created=new StackNode<T>(element);
		if(top==null) {
			top = created;
		}else{
			top.setTop(created);
			created.setBottom(top);
			top=created;
		}
		size++;
	}

	public T pop() {
		if(top==null) {
			return null;
		}else {
			T output = top.getContent();
			StackNode<T> newKing = top.getBottom();
			if (newKing != null)
				newKing.setTop(null);

			top.setBottom(null);
			top = newKing;
			size--;
			return output;
		}
	}

	public T peek() {
		return top!=null? top.getContent(): null;
	}

	public boolean isEmpty() {
		return top==null;
	}

	public int getSize() {
		return this.size;
	}

	public StackNode<T> getTop() {
		return top;
	}

	public void setTop(StackNode<T> top) {
		this.top = top;
	}

}