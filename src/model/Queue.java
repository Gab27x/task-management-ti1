import java.util.ArrayList;

public class Queue<T> {
	private ArrayList<T> queue;
	private int size;

	public Queue() {
		this.queue = new ArrayList<T>();
		this.size = 0;
	}

	public void add(T element){
		queue.add(element);
		size ++;
	}

	public T poll(){
		if(isEmpty()){
			return null;
		}
		else {
			T firstOut = queue.get(0);
			queue.remove(0);
			size --;
			return firstOut;

		}
	}

	public T peek(){
		return queue.get(0);
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public ArrayList<T> getQueue() {
		return queue;
	}

	public void setQueue(ArrayList<T> queue) {
		this.queue = queue;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}






