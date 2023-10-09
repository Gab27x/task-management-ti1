import model.MaxHeap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    private MaxHeap<Integer> maxHeapTest;

    public void MaxHeapTest(){
        maxHeapTest = new MaxHeap<>();
    }

    public void setUp(){
        MaxHeapTest();
        maxHeapTest.insert(1);
    }

    public void setUp1(){
        MaxHeapTest();
        maxHeapTest.insert(1);
        maxHeapTest.insert(3);
        maxHeapTest.insert(2);
        maxHeapTest.insert(5);
        maxHeapTest.insert(4);
    }

    @Test
    public void isEmptyTest(){
        //set Up
        MaxHeapTest();

        //act
        boolean result = maxHeapTest.isEmpty();

        //assert
        assertTrue(result);
    }

    @Test
    public void isEmptyTest1(){
        //set Up
        setUp();

        //act
        boolean result = maxHeapTest.isEmpty();

        //assert
        assertFalse(result);
    }

    @Test
    public void addTest(){
        //set Up
        MaxHeapTest();

        //act
        maxHeapTest.insert(2);

        //assert
        assertFalse(maxHeapTest.isEmpty());
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
        maxHeapTest.addElements(elements);

        //assert
        assertFalse(maxHeapTest.isEmpty());
    }

    @Test
    public void peekMaxTest(){
        //set Up
        setUp();

        //act
        Integer result = maxHeapTest.peekMax();

        //assert
        assertEquals(1,result);
    }

    @Test
    public void peekMaxTest1(){
        //set Up
        setUp1();

        //act
        Integer result = maxHeapTest.peekMax();

        //assert
        assertEquals(5,result);
    }

    @Test
    public void extractMaxTest(){
        //set Up
        MaxHeapTest();

        //act
        Integer result = maxHeapTest.extractMax();

        //assert
        assertNull(result);
    }

    @Test
    public void extractMaxTest1(){
        //set Up
        setUp();

        //act
        Integer result = maxHeapTest.extractMax();

        //assert
        assertEquals(1,result);
    }

    @Test
    public void extractMaxTest2(){
        //set Up
        setUp1();

        //act
        Integer result = maxHeapTest.extractMax();

        //assert
        assertEquals(5,result);
    }

    @Test
    public void getSortedArray(){
        //set Up
        setUp1();

        //act
        Integer[] result = maxHeapTest.getSortedArray(Integer.class);

        //assert
        assertEquals(5,result[0]);
        assertEquals(4,result[1]);
        assertEquals(3,result[2]);
        assertEquals(2,result[3]);
        assertEquals(1,result[4]);
    }



}