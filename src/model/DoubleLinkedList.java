package model;

public class DoubleLinkedList<T> {
    private NodeDoubleLinkedList<T> head;
    private NodeDoubleLinkedList<T> tail;
    private int size;

    public void addFirst(T data) {
        NodeDoubleLinkedList<T> newNode = new NodeDoubleLinkedList<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        NodeDoubleLinkedList<T> newNode = new NodeDoubleLinkedList<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            NodeDoubleLinkedList<T> newNode = new NodeDoubleLinkedList<>(data);
            NodeDoubleLinkedList<T> current = getNodeAtIndex(index);
            newNode.setPrev(current.getPrev());
            newNode.setNext(current);
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
            size++;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        T data = head.getData();
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        T data = tail.getData();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
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
            NodeDoubleLinkedList<T> current = getNodeAtIndex(index);
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            size--;
            return current.getData();
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return getNodeAtIndex(index).getData();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private NodeDoubleLinkedList<T> getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        NodeDoubleLinkedList<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public NodeDoubleLinkedList<T> find(T objective) {
        NodeDoubleLinkedList<T> current = head;
        while (current != null) {
            if (current.getData().equals(objective)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    public void removeFind(T objective) {
        NodeDoubleLinkedList<T> current = head;
        while (current != null) {
            if (current.getData().equals(objective)) {
                if(current== this.head){
                    removeFirst();
                }else if(current==this.tail){
                    removeLast();
                }else{
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                    size--;
                }

            }
            current = current.getNext();
        }

    }



}


