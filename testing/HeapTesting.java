import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapTesting {

    private Heap<Integer> heapTest;

    public HeapTesting(){
        heapTest = new Heap<>(new Integer[10]);
    }

    public void setUp1(){
        heapTest.addNode(1);
    }

    @Test
    public void insertNodeTest(){
        // set Up

        // act
        heapTest.addNode(1);

        // Assert
        assertFalse(heapTest.isEmpty());
    }

    public void getElements(){
        //set Up

        //act
        Integer[] values=heapTest.getHeapData();
    }





}
