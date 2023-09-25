public class NodeDoubleLinkedList<T> {
    private T data;
    NodeDoubleLinkedList<T> prev;
    NodeDoubleLinkedList<T> next;

    NodeDoubleLinkedList(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeDoubleLinkedList<T> getPrev() {
        return prev;
    }

    public void setPrev(NodeDoubleLinkedList<T> prev) {
        this.prev = prev;
    }

    public NodeDoubleLinkedList<T> getNext() {
        return next;
    }

    public void setNext(NodeDoubleLinkedList<T> next) {
        this.next = next;
    }
}
