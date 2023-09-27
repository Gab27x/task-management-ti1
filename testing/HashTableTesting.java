import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTesting {

    private HashTable<Integer,Integer> hashTableTest;
    public void HashTableTesting(){
        hashTableTest = new HashTable<>();
    }



    @Test
    void addTest(){
        HashTableTesting();
        hashTableTest.add(1,2);
        assertFalse(hashTableTest.isEmpty());

    }

    public void setUp1(){
        HashTableTesting();
        hashTableTest.add(1,1);
        hashTableTest.add(2,2);
        hashTableTest.add(3,3);
    }


    @Test
    void getValueTest(){
        setUp1();
        Integer result = hashTableTest.getValue(1);
        assertEquals(1,result);
    }

    @Test
    void getFirstTest(){
        setUp1();
        HashEntry<Integer,Integer> result=hashTableTest.getFirst(1);
        Integer expectedValue=1;
        assertEquals(1,result.getValue());

    }

    public void setUp2(){
        HashTableTesting();
        hashTableTest.add(240,1);
        hashTableTest.add(40,2);
        hashTableTest.add(8,1);
        hashTableTest.add(7,2);
    }


    @Test
    void findValueTest() {
        setUp2();
        Integer result=hashTableTest.findValue(40);
        assertEquals(2,result);
    }

    @Test
    void findTest(){
        setUp2();
        HashEntry<Integer,Integer> result = hashTableTest.find(240);
        Integer resultValue=result.getValue();
        Integer expectedResult=1;
        assertEquals(expectedResult, resultValue);
    }
    @Test
    void deleteTest(){
        setUp1();
        hashTableTest.delete(1,1);
        HashEntry<Integer,Integer> result=hashTableTest.getFirst(1);
        assertNull(result);
    }

    @Test
    void isEmptyTest(){
        HashTableTesting();
        boolean result= hashTableTest.isEmpty();
        assertTrue(result);
    }
    @Test
    void isEmptyNegativeTest(){
        setUp1();
        boolean result= hashTableTest.isEmpty();
        assertFalse(result);
    }






}
