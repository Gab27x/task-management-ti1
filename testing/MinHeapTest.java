import model.MinHeap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    private MinHeap<Integer> minHeapTest;

    public void MaxHeapTest(){
        minHeapTest = new MinHeap<>();
    }

    public void setUp(){
        MaxHeapTest();
        minHeapTest.insert(1);
    }

    public void setUp1(){
        MaxHeapTest();
        minHeapTest.insert(1);
        minHeapTest.insert(3);
        minHeapTest.insert(2);
        minHeapTest.insert(5);
        minHeapTest.insert(4);
    }

    @Test
    public void isEmptyTest(){
        //set Up
        MaxHeapTest();

        //act
        boolean result = minHeapTest.isEmpty();

        //assert
        assertTrue(result);
    }

    @Test
    public void isEmptyTest1(){
        //set Up
        setUp();

        //act
        boolean result = minHeapTest.isEmpty();

        //assert
        assertFalse(result);
    }

    @Test
    public void addTest(){
        //set Up
        MaxHeapTest();

        //act
        minHeapTest.insert(2);

        //assert
        assertFalse(minHeapTest.isEmpty());
    }

    @Test
    public void addElements(){
        //set Up
        MaxHeapTest();

        //act
        ArrayList<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        minHeapTest.addElements(elements);

        //assert
        assertFalse(minHeapTest.isEmpty());
    }

    @Test
    public void peekMaxTest(){
        //set Up
        setUp();

        //act
        Integer result = minHeapTest.peekMin();

        //assert
        assertEquals(1,result);
    }

    @Test
    public void peekMaxTest1(){
        //set Up
        setUp1();

        //act
        Integer result = minHeapTest.peekMin();

        //assert
        assertEquals(5,result);
    }

    @Test
    public void peekMaxTest2(){
        //set Up
        MaxHeapTest();

        //act
        Integer result = minHeapTest.peekMin();

        //assert
        assertNull(result);
    }

    @Test
    public void extractMaxTest(){
        //set Up
        MaxHeapTest();

        //act
        Integer result = minHeapTest.extractMin();

        //assert
        assertNull(result);
    }

    @Test
    public void extractMaxTest1(){
        //set Up
        setUp();

        //act
        Integer result = minHeapTest.extractMin();

        //assert
        assertEquals(1,result);
    }

    @Test
    public void extractMaxTest2(){
        //set Up
        setUp1();

        //act
        Integer result = minHeapTest.extractMin();

        //assert
        assertEquals(5,result);
    }

    @Test
    public void getHeapTest(){
        //set Up
        MaxHeapTest();

        //act
        ArrayList<Integer> result = minHeapTest.getHeap();

        //assert
        assertEquals(0,result.size());
    }

    @Test
    public void getHeapTest1(){
        //set Up
        setUp1();

        //act
        ArrayList<Integer> result = minHeapTest.getHeap();

        //assert
        assertEquals(5,result.size());
    }


}