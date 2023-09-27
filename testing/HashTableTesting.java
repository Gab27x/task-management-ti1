import model.HashTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;




public class HashTableTesting {

    private HashTable<Integer,Integer> hashTableTest;


    public void setUp() {
        hashTableTest = new HashTable<>();
    }
    public void setUp2() {
        hashTableTest = new HashTable<>(100);
    }
    @Test
    public void testConstructorMethodEmptyList(){
        setUp();

        assertTrue(hashTableTest.isEmpty());
    }
    @Test
    public void testConstructorMethodEmptyListGivenSize(){
        setUp2();
        assertEquals(100, hashTableTest.getDefaultSize());
    }

    @Test
    public void testAddMethodEmptyList(){
        setUp();
        hashTableTest.add(1,2);
        assertFalse(hashTableTest.isEmpty());
    }
    @Test
    public void testAddMethodEmptyListTwoElementsInserted(){
        setUp();
        hashTableTest.add(1,2);
        hashTableTest.add(2,4);
        assertFalse(hashTableTest.isEmpty());
    }
    @Test
    public void testAddMethodEmptyListGivenSize(){
        setUp2();
        hashTableTest.add(1,2);
        assertFalse(hashTableTest.isEmpty());
    }

    @Test
    public void testAddMethodEmptyListGivenSizeTwoElementsInserted(){
        setUp2();
        hashTableTest.add(1,2);
        hashTableTest.add(2,4);
        assertFalse(hashTableTest.isEmpty());
    }

    @Test
    public void testAddMethodEmptyListCollisions(){
        setUp();
        hashTableTest.add(1,2);
        hashTableTest.add(1,4);
        assertEquals(hashTableTest.find(1,4).getValue(),4);
    }

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








}
