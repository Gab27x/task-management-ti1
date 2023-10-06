import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapTesting {

    private Heap<Integer> heapTest;

    public HeapTesting(){
        heapTest = new Heap<>(new Integer[4]);
    }

    public void setUp1(){
        heapTest.addNode(1);
    }

    public void setUp2(){
        heapTest.addNode(2);
        heapTest.addNode(5);
        heapTest.addNode(3);
        heapTest.addNode(1);
    }

    @Test
    public void getMaxSizeTest(){
        //set Up


        //act
        int maxSize=heapTest.getMaxSize();

        //Assert
        assertEquals(4,maxSize);
    }

    @Test
    public void insertNodeTest(){
        // set Up

        // act
        heapTest.addNode(1);

        // Assert
        assertFalse(heapTest.isEmpty());
    }

    @Test
    public void getElements(){
        //set Up

        //act
        Integer[] values=heapTest.getHeapData();
        Integer expected=values[0];

        //Assert
        assertNull(expected);
    }

    @Test
    public void getElements2(){
        //set Up
        setUp1();

        //act
        Integer[] values=heapTest.getHeapData();
        Integer value=values[0];

        //Assert
        assertNotNull(value);

    }

    @Test
    public void getElements3(){
        //set Up
        setUp2();

        //act
        Integer[] values=heapTest.getHeapData();
        Integer value=values[0];


        //Assert
        assertNotNull(value);
    }

    @Test
    public void getElements4(){
        //set Up
        setUp2();

        //act
        Integer[] values=heapTest.getHeapData();
        Integer value=values[6];

        //Assert
        assertNull(value);
    }

    @Test
    public void isEmpty(){
        //set Up

        //act
        boolean isEmpty=heapTest.isEmpty();

        //Assert
        assertTrue(isEmpty);
    }

    @Test
    public void isEmpty1(){
        //set Up
        setUp1();

        //act
        boolean isEmpty=heapTest.isEmpty();

        //Assert
        assertFalse(isEmpty);
    }

    @Test
    public void isEmpty2(){
        //set Up
        setUp2();

        //act
        boolean isEmpty=heapTest.isEmpty();

        //Assert
        assertFalse(isEmpty);
    }

    @Test
    public void getSizeTest(){
        //set Up


        //act
        int size=heapTest.getSize();

        //Assert
        assertEquals(0,size);
    }

    @Test
    public void getSizeTest1(){
        //set Up
        setUp1();

        //act
        int size=heapTest.getSize();

        //Assert
        assertEquals(1,size);
    }

    @Test
    public void getSizeTest2(){
        //set Up
        setUp2();

        //act
        int size=heapTest.getSize();

        //Assert
        assertEquals(4,size);
    }

    @Test
    public void designHeapTest(){//FIXME this test is not working
        //set Up
        setUp2();

        //act
        heapTest.designMaxHeap();
        Integer[] expected={5,3,2,1,null,null,null,null,null,null};

        //Assert
        assertEquals(expected,heapTest.getHeapData()[0]);
    }

    @Test
    public void designHeapTest1(){//FIXME this test is not working
        //set Up
        setUp2();

        //act
        //heapTest.designMaxHeap();
        Integer expected=5;

        //Assert
        assertEquals(expected,heapTest.getHeapData()[0]);
        assertEquals(3,heapTest.getHeapData()[1]);

    }





}
