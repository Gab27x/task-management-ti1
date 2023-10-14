import model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTesting {

    private HashTable<Integer,Integer> hashTableTest;
    public void HashTableTesting(){
        hashTableTest = new HashTable<>();
    }


    public void setUp1(){
        HashTableTesting();
        hashTableTest.add(1,1);
        hashTableTest.add(2,2);
        hashTableTest.add(3,3);
    }

    @Test
    void hashFunctionTest(){
        setUp1();
        String key="5";
        int index= hashTableTest.hashFunction(5);
        assertInstanceOf(Integer.class,index);
    }

    @Test
    void addTest(){
        HashTableTesting();
        hashTableTest.add(1,2);
        assertFalse(hashTableTest.isEmpty());
    }

    @Test
    void addCollisions(){
        setUp1();
        //Although the new values have different keys, they will be in the same index
        hashTableTest.add(10,10);
        hashTableTest.add(0,0);
        assertEquals(5,hashTableTest.getExistingNodes());
    }


    @Test
    void getValueTest(){
        setUp1();
        Integer result = hashTableTest.getValue(1);
        assertEquals(1,result);
    }

    @Test
    void testGetValueNonExistentElement() {
        setUp1();
        int key =hashTableTest.hashFunction(4);
        assertNull(hashTableTest.getTable()[key]);
    }
    @Test
    void testGetValueCollisions(){
        setUp1();
        hashTableTest.add(1,2);
        assertEquals(1,hashTableTest.getValue(1));

    }


    @Test
    void getFirstTest(){
        setUp1();
        HashEntry<Integer,Integer> result=hashTableTest.getFirst(1);
        Integer expectedValue=1;
        assertEquals(1,result.getValue());

    }

    @Test
    void getFirstNullTest(){
        setUp1();
        assertNull(hashTableTest.getFirst(5));
    }

    @Test
    void getFirstCollisions(){
        setUp1();
        hashTableTest.add(1,2);
        HashEntry<Integer,Integer> result = new HashEntry<>(1,1);
        assertEquals(result.getValue(),hashTableTest.getFirst(1).getValue());

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
    void findNullValueTest(){
        setUp2();
        Integer result=hashTableTest.findValue(500);
        assertNull(result);

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
    void findNullTest(){
        setUp2();
        HashEntry<Integer,Integer> result = hashTableTest.find(500);
        assertNull(result);

    }
    @Test
    void deleteTest(){
        setUp1();
        hashTableTest.delete(1,1);
        HashEntry<Integer,Integer> result=hashTableTest.getFirst(1);
        assertNull(result);
    }
    @Test
    public void testDeleteNonExistentElement() {
        setUp1();
        hashTableTest.delete(0,0);
        assertEquals(3,hashTableTest.getExistingNodes());
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
