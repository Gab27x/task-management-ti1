public class NodeDoubleLinkedList<T> {
    private T data;
    DoubleLinkedList.Node<T> prev;
    DoubleLinkedList.Node<T> next;

    Node(T data) {
        this.data = data;
    }
}
