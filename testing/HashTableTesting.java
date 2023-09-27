import model.HashTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/*
Most of your mistakes are for not using the appropriated structure for the test
also some test are redundant and unnecesary
be careful with raw data please fix the structure

*/
public class HashTableTesting {

    private HashTable<Integer,Integer> hashTableTest;
    public HashTableTesting(){
        hashTableTest = new HashTable<>();
    }


/*    public void setUp() {
        hashTableTest = new HashTable<>();
    }
    public void setUp2() {
        hashTableTest = new HashTable<>(100);
    }*/

    //fixed
    @Test
    public void testConstructorMethodEmptyList(){

        assertTrue(hashTableTest.isEmpty());
    }
    //fixed
    @Test
    public void testConstructorMethodEmptyListGivenSize(){
        // defult size is 200
        assertEquals(200, hashTableTest.getDefaultSize());
    }

    //fixed
    @Test
    public void testAddMethodEmptyList(){
        hashTableTest.add(1,2);
        assertFalse(hashTableTest.isEmpty());
    }



    // unnecesary test only keep one

/*    @Test
    public void testAddMethodEmptyListTwoElementsInserted(){
        setUp();
        hashTableTest.add(1,2);
        hashTableTest.add(2,4);
        assertFalse(hashTableTest.isEmpty());
    }*/

    // i dont see the point of this test
/*    @Test
    public void testAddMethodEmptyListGivenSize(){
        setUp2();
        hashTableTest.add(1,2);
        assertFalse(hashTableTest.isEmpty());
    }*/


// redundant test
/*    @Test
    public void testAddMethodEmptyListGivenSizeTwoElementsInserted(){
        setUp2();
        hashTableTest.add(1,2);
        hashTableTest.add(2,4);
        assertFalse(hashTableTest.isEmpty());
    }*/

// the test is bad designed
/*    @Test
    public void testAddMethodEmptyListCollisions(){

        hashTableTest.add(1,2);
        hashTableTest.add(1,4);
        assertEquals(hashTableTest.find(1,4).getValue(),4);
    }*/
    // correction
    @Test
    public void testAddMethodEmptyListCollisions(){

        hashTableTest.add(1,2);
        hashTableTest.add(1,4);
        // Raw data used fix the structure
        Integer Expected = hashTableTest.find(1,4).getValue();

        assertEquals(hashTableTest.find(1,4).getValue(),4);
    }


        /*

    @Test
    public void testAddMethodEmptyListGivenSizeCollisions(){
        setUp2();
        hashTableTest.add(1,2);
        hashTableTest.add(1,4);
        assertEquals(hashTableTest.find(1,4).getValue(),4);
    }

    public void setUp3(){
        setUp();
        hashTableTest.add(1,1);
        hashTableTest.add(1,2);
        hashTableTest.add(2,1);
        hashTableTest.add(2,2);
    }

    @Test
    public void testSearchMethodFirstPosition(){
        setUp3();
        assertEquals( hashTableTest.getFirst(1).getValue(),1);

    }

    @Test
    public void testFindMethod(){
        setUp3();
        assertEquals( hashTableTest.find(1,2).getValue(),2);
    }
    @Test
    public void testFindMethodNotExistingElement(){
        setUp3();
        assertNull(hashTableTest.find(1,5).getValue());
    }
    @Test
    public void testFindMethodNotIndexElement(){
        setUp3();
        assertNull(hashTableTest.find(5,1).getValue());
    }
    @Test
    public void testSearchElementEmptyTable(){
        setUp();
        assertNull(hashTableTest.getFirst(1));
    }

    @Test
    public void testFindElementEmptyTable(){
        setUp();
        assertNull(hashTableTest.find(1,1));
    }

    public void setUp4(){
        setUp();
        hashTableTest.add(1,1);
        hashTableTest.add(2,2);
        hashTableTest.add(3,3);
        hashTableTest.add(4,4);
    }


    @Test
    public void deletionMethodIndexWithUniqueElement(){
        setUp4();
        hashTableTest.delete(1,1);
        assertNull(hashTableTest.getFirst(1));

    }



    @Test
    public void deletionMethodCollisions(){
        setUp3();
        hashTableTest.delete(1,2);
        assertNull(hashTableTest.find(1,2));

    }

    @Test
    public void deletionNotExistingElementIndexWithUniqueElement(){
        setUp4();
        hashTableTest.delete(1,2);
        assertNotNull(hashTableTest.getFirst(1));
    }

    @Test
    public void deletionNotExistingElementCollisions(){
        setUp3();
        hashTableTest.delete(1,5);
        assertNotNull(hashTableTest.getFirst(1));
    }

*/






}
