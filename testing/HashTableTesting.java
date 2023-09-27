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
        assertTrue(hashTableTest.isEmpty());
        assertEquals(200,hashTableTest.getDefaultSize());
    }
    @Test
    public void testConstructorMethodEmptyListGivenSize(){
        setUp2();
        assertTrue(hashTableTest.isEmpty());
        assertEquals(100, hashTableTest.getDefaultSize());

    }
    @Test
    public void testAddMethodEmptyList(){
        setUp();
        assertEquals(200,hashTableTest.getDefaultSize());
        hashTableTest.add(1,2);
        assertFalse(hashTableTest.isEmpty());
        assertEquals(hashTableTest.getFirst(1).getValue(),2);
        assertNotEquals(0, hashTableTest.getExistingNodes());
    }
    @Test
    public void testAddMethodEmptyListTwoElementsInserted(){
        setUp();
        assertEquals(200,hashTableTest.getDefaultSize());
        hashTableTest.add(1,2);
        hashTableTest.add(2,4);
        assertFalse(hashTableTest.isEmpty());
        assertEquals(hashTableTest.getFirst(1).getValue(),2);
        assertEquals(hashTableTest.getFirst(2).getValue(),4);
        assertEquals(2, hashTableTest.getExistingNodes());
    }
    @Test
    public void testAddMethodEmptyListGivenSize(){
        setUp2();
        assertEquals(100,hashTableTest.getDefaultSize() );
        hashTableTest.add(1,2);
        assertFalse(hashTableTest.isEmpty());
        assertEquals(hashTableTest.getFirst(1).getValue(),2);
        assertNotEquals(0, hashTableTest.getExistingNodes());
    }

    @Test
    public void testAddMethodEmptyListGivenSizeTwoElementsInserted(){
        setUp2();
        assertEquals(100,hashTableTest.getDefaultSize() );
        hashTableTest.add(1,2);
        hashTableTest.add(2,4);
        assertFalse(hashTableTest.isEmpty());
        assertEquals(hashTableTest.getFirst(1).getValue(),2);
        assertEquals(hashTableTest.getFirst(2).getValue(),4);
        assertEquals(2, hashTableTest.getExistingNodes());
    }

    @Test
    public void testAddMethodEmptyListCollisions(){
        setUp();
        hashTableTest.add(1,2);
        hashTableTest.add(1,4);
        assertFalse(hashTableTest.isEmpty());
        assertEquals(hashTableTest.getFirst(1).getValue(),2);
        assertEquals(hashTableTest.find(1,4).getValue(),4);
    }

    @Test
    public void testAddMethodEmptyListGivenSizeCollisions(){
        setUp2();
        hashTableTest.add(1,2);
        hashTableTest.add(1,4);
        assertFalse(hashTableTest.isEmpty());
        assertEquals(hashTableTest.getFirst(1).getValue(),2);
        assertEquals(hashTableTest.find(1,4).getValue(),4);
    }

    public void setUp3(){
        setUp();
        hashTableTest.add(1,2);
        hashTableTest.add(1,4);
        hashTableTest.add(2,5);
        hashTableTest.add(2,6);
    }

    @Test
    public void testSearchMethodFirstPosition(){
        setUp3();
        assertNotNull(hashTableTest.getFirst(1));
        assertEquals(2, hashTableTest.getFirst(1).getValue());

    }

    @Test
    public void testFindMethod(){
        setUp3();
        assertEquals(4, hashTableTest.find(1,4).getValue());
    }
    @Test
    public void testFindMethodNotExistingElement(){
        setUp3();
        assertNull(hashTableTest.find(1,5).getValue());
    }
    @Test
    public void testSearchElementEmptyTable(){
        setUp();
        assertNull(hashTableTest.getFirst(1));
    }

    @Test
    public void testFindElementEmptyTable(){
        setUp();
        assertNull(hashTableTest.find(1,5));
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
        setUp3();
        hashTableTest.delete(1,1);
        assertNull(hashTableTest.getFirst(1));

    }



    @Test
    public void deletionMethodCollisions(){
        setUp3();
        hashTableTest.delete(1,2);
        assertNotNull(hashTableTest.getFirst(1));
        assertEquals(4, hashTableTest.getFirst(1).getValue());

    }








}
