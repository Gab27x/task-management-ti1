
import model.Queue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class QueueTest {
    private Queue<Integer> queueTest;

    public QueueTest(){
        queueTest =  new Queue<>();
    }

    public void setUp1(){
        queueTest.add(1);

    }
    public void setUp2(){
        queueTest.add(1);
        queueTest.add(2);
        queueTest.add(3);
        queueTest.add(4);


    }


    @Test
    public void addTest(){
        // set Up

        // act
        queueTest.add(1);

        // Assert
        assertFalse(queueTest.isEmpty());
    }

    // verify that the structure is fifo
    @Test
    public void addTest2(){
        // set Up
        setUp2();
        // act
        Integer top = queueTest.getTop().getContent();

        // Assert
        assertEquals(1,top);

    }

    @Test
    public void addTest3(){
        // set Up
        setUp1();
        // act
        queueTest.add(2);
        Integer last = queueTest.getLast().getContent();

        // Assert
        assertEquals(2, last);

    }

    @Test
    public void getSizeTest(){
        // set Up
        setUp2();
        // act
        Integer size = queueTest.getSize();

        // Assert
        assertEquals(4,size);

    }
    @Test
    public void getSizeTest2(){
        // set Up
        setUp2();
        // act
        queueTest.poll();
        Integer size = queueTest.getSize();

        // Assert
        assertEquals(3,size);

    }

    @Test
    public void pollTest(){
        // set Up
        setUp2();
        // act
        Integer result = queueTest.poll();

        // Assert
        assertEquals(1,result);

    }

    @Test
    public void pollTest2(){
        // set Up

        // act
        Integer result = queueTest.poll();

        // Assert
        assertNull(result);

    }


    @Test
    public void peekTest(){
        // set Up
        setUp1();

        // act
        Integer result = queueTest.peek();

        // Assert
        assertEquals(1,result);

    }
    @Test
    public void isEmptyTest(){
        // set Up

        // act
        boolean result = queueTest.isEmpty();

        // Assert
        assertTrue(result);
    }

    @Test
    public void fifoWorksTest() {
        // set Up
        setUp2();

        // act
        queueTest.poll();
        Integer newTop = queueTest.getTop().getContent();


        // Assert
        assertEquals(2, newTop);
    }

    @Test
    public void fifoWorksTest2() {
        // set Up
        setUp2();

        // act
        queueTest.poll();
        Integer top = queueTest.peek();

        // Assert
        assertEquals(2, top);
    }
    @Test
    public void showQueueTest(){

        // set Up

        // act
        String result = queueTest.showQueue();
        String expected = "Queue is empty";

        // Assert
        assertEquals(expected,result);

    }

    @Test
    public void showQueueTest2(){

        // set Up
        setUp1();

        // act
        String result = queueTest.showQueue();
        String expected = "\n1\n";

        // Assert
        assertEquals(expected,result);

    }


}
