package model;
public class Queue<T> {
	private QueueNode<T> top;
	private QueueNode<T> last;
	private int size;

	public Queue() {
		this.top = null;
		this.last = null;
		this.size = 0;
	}

	public void add(T element){
		QueueNode<T> newNode = new QueueNode<T>(element);
		// The list is empty
		if(top == null){
			top = newNode;
        }
		else{
			this.last.setNext(newNode);
			newNode.setPrevious(this.last);
        }

        last = newNode;
        size++;
	}

	public T poll(){
		if(top == null){
			return null;
		}
		else {
			T firstOut = top.getContent();

			if(top == last){
				top = null;
				last = null;
			}
			else {
				QueueNode<T> newTop = top.getNext();

				newTop.setPrevious(null);
				top.setNext(null);

				top = newTop;

			}

			size--;
			return firstOut;
		}

	}


	public T peek(){
		return top.getContent();
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public String showQueue(){
		return showQueue(top);
	}
	private String showQueue(QueueNode<T> node){
		if(node == null){
			return "Queue is empty";
		}
		else{
			return "\n" + node.getContent() + "\n" + showQueue(node.getNext());
		}
	}


	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}






