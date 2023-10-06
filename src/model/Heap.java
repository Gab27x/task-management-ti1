package model;

public class Heap<T extends Comparable<T>> {

    // declare array and variables
    private T[] heapData;
    private int sizeOfHeap;
    private int heapMaxSize;

    private static final int FRONT = 1;

    //use constructor to initialize heapData array
    public Heap(T[] datos)  {
        this.heapMaxSize = datos.length;
        this.sizeOfHeap = 0;
        heapData = datos;
    }

    public int getMaxSize(){
        return this.heapMaxSize;
    }

    public int getSize(){
        return this.sizeOfHeap;
    }

    public T[] getHeapData(){
        return this.heapData;
    }

    // create getParentPos() method that returns parent position for the node
    public int getParentPosition(int position)  {
        return (position - 1) / 2;
    }

    // create getLeftChildPosition() method that returns the position of left child
    public int getLeftChildPosition(int position)  {
        return (2 * position);
    }

    // create getRightChildPosition() method that returns the position of right child
    public int getRightChildPosition(int position)  {
        return (2 * position) + 1;
    }

    // checks whether the given node is leaf or not
    public boolean checkLeaf(int position)  {
        if (position > (sizeOfHeap / 2) && position <= sizeOfHeap) {
            return true;
        }
        return false;
    }

    // create swapNodes() method that perform swapping of the given nodes of the heap
// firstNode and secondNode are the positions of the nodes
    public void swap(int firstNode, int secondNode)  {
        T temp;
        temp = heapData[firstNode];
        heapData[firstNode] = heapData[secondNode];
        heapData[secondNode] = temp;
    }

    // create maxHeapify() method to heapify the node for maintaining the heap property
    public void maxHeapify(int position)  {

        //check whether the given node is non-leaf and greater than its right and left child
        if (!checkLeaf(position)) {
            if ((heapData[position].compareTo(heapData[getLeftChildPosition(position)]) <= -1 || (heapData[position].compareTo(heapData[getRightChildPosition(position)])) <= -1)) {

                // swap with left child and then heapify the left child
                if (heapData[getLeftChildPosition(position)].compareTo(heapData[getRightChildPosition(position)]) >= 1) {
                    swap(position, getLeftChildPosition(position));
                    maxHeapify(getLeftChildPosition(position));
                }

                // Swap with the right child and heapify the right child
                else {
                    swap(position, getRightChildPosition(position));
                    maxHeapify(getRightChildPosition(position));
                }
            }
        }

    }

    // create insertNode() method to insert element in the heap
    public void addNode(T data)  {
        heapData[sizeOfHeap] = data;
        int current = sizeOfHeap;

        while (heapData[current].compareTo(heapData[getParentPosition(current)])>=1) {
            swap(current, getParentPosition(current));
            current = getParentPosition(current);
        }
        sizeOfHeap++;
    }

    // create displayHeap() method to print the data of the heap
    public String displayHeap()  {
        String out="";
        //System.out.println("PARENT NODE" + "\t" + "LEFT CHILD NODE" + "\t" + "RIGHT CHILD NODE");
        for (int k = 0; k <sizeOfHeap / 2; k++) {
            out+=" " + heapData[k] + "\n" + heapData[2 * k + 1] + "\n" + heapData[2 * k + 2]+"\n";
        }
        return out;
    }

    // create designMaxHeap() method to construct min heap
    public void designMaxHeap()  {
        for (int position = 0;  position < (sizeOfHeap / 2); position++) {
            maxHeapify(position);
        }
    }

    // create removeRoot() method for removing maximum element from the heap
    public T removeRoot()  {
        T popElement = heapData[FRONT];
        heapData[FRONT] = heapData[sizeOfHeap--];
        maxHeapify(FRONT);
        return popElement;
    }

    public boolean isEmpty(){
        return sizeOfHeap == 0;
    }

}
