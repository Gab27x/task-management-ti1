import model.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTesting {
    private Stack<Integer> stackTest;
    public StackTesting(){
        stackTest = new Stack<>();
    }


    public void setUp1(){
        stackTest.push(1);
    }

    public void setUp2(){
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(3);
        stackTest.push(4);
    }

    @Test
    public void pushTest(){
        // set Up

        // act
        stackTest.push(1);

        // Assert
        assertFalse(stackTest.isEmpty());
    }

    @Test
    public void topTest2(){
        // set Up
        setUp2();
        // act
        Integer top = stackTest.getTop().getContent();

        // Assert
        assertEquals(4,top);

    }
    @Test
    public void popTest(){
        // set Up
        setUp2();

        // act
        Integer top = stackTest.pop();

        // Assert
        assertEquals(4,top);

    }

    @Test
    public void popTest3(){
        // set Up
        setUp1();

        // act
        Integer top = stackTest.pop();

        // Assert
        assertEquals(1,top);

    }

    @Test
    public void popTest2(){
        // set Up

        // act
        Integer top = stackTest.pop();

        // Assert
        assertNull(top);

    }
    @Test
    public void peekTest(){
        // set Up
        setUp2();

        // act
        Integer top = stackTest.peek();

        // Assert
        assertEquals(4,top);

    }

    @Test
    public void peekTest2(){
        // set Up

        // act
        Integer top = stackTest.peek();

        // Assert
        assertNull(top);

    }

    @Test
    public void peekTest3(){
        //set Up
        setUp1();

        //act
        Integer top = stackTest.peek();

        //Assert
        assertEquals(1,top);
    }

    @Test
    public void isEmptyTest(){
        // set Up


        // act
        boolean isEmpty = stackTest.isEmpty();

        // Assert
        assertTrue(isEmpty);

    }

    @Test
    public void isEmptyTest2(){
        // set Up
        setUp1();

        // act
        boolean isEmpty = stackTest.isEmpty();

        //Assert
        assertFalse(isEmpty,"Stack is not empty");
    }

    @Test
    public void getSizeTest0(){
        // set Up
        setUp1();

        // act
        int size = stackTest.getSize();

        // Assert
        assertEquals(1,size);
    }

    @Test
    public void getSizeTest(){
        // set Up
        setUp2();

        // act
        int size = stackTest.getSize();

        // Assert
        assertEquals(4,size);

    }

    @Test
    public void getSizeTest2(){
        // set Up


        // act
        int size = stackTest.getSize();

        // Assert
        assertEquals(0,size);

    }







}