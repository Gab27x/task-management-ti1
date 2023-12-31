package model;
import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void insert(T element) {
        heap.add(element);
        int index = heap.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                // Swap with parent
                T temp = heap.get(index);
                heap.set(index, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                index = parentIndex;
            } else {
                break;
            }
        }
    }


    public T peekMin() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void addElements(ArrayList<T> elements) {
        for (T element : elements) {
            insert(element);
        }
    }

    public T extractMin() {
        if (heap.isEmpty()) {
            return null;
        }

        T min = heap.get(0);

        heap.set(0, heap.get(heap.size() - 1));

        heap.remove(heap.size() - 1);

        int index = 0;

        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largest = index;

            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(largest)) > 0) {
                largest = leftChildIndex;
            }

            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(largest)) > 0) {
                largest = rightChildIndex;
            }

            if (largest != index) {
                // Swap with the largest child
                T temp = heap.get(index);
                heap.set(index, heap.get(largest));
                heap.set(largest, temp);
                index = largest;
            } else {
                break;
            }
        }

        return min;
    }

    public ArrayList<T> getHeap() {
        return heap;
    }

    public void setHeap(ArrayList<T> heap) {
        this.heap = heap;
    }
}
