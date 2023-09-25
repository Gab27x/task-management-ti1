public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T data) {


        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = getNodeAtIndex(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        T data = head.data;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        T data = tail.data;
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<T> current = getNodeAtIndex(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return current.data;
        }
    }

    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return getNodeAtIndex(index).data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> getNodeAtIndex(int index) {
        if (index < 0 ) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private Node<T> getNodeByData(T data) {
        Node<T> objective = new Node<>(data);
        return getNodeByData(data, objective, this.head);
    }

    private Node<T> getNodeByData(T data, Node<T> objective, Node<T> current){
        if(objective==this.head){
            return head;
        }else if(objective==this.tail){
            return tail;
        }else if(current==objective){
            return current;
        }

        return (data, objective, current.next);

    }
}

