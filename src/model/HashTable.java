

public class HashTable<K,V> {



	private HashEntry [] table;
	private int existingNodes;

	private static final int defaultSize=200;
	public HashTable(){
		HashEntry[] table= new HashEntry[defaultSize];
		this.existingNodes=0;
	}

	public int hashFunction(K key){
		int hashCode= key.hashCode();
		return Math.abs(hashCode) % table.length;
	}
	public void add(K key, V value){
		HashEntry newEntry= new HashEntry<>(key, value);
		int index=hashFunction(key);
		if(table[index]==null){
			table[index]=newEntry;
			existingNodes++1,
		}else{
			table[index].getList().addLast(newEntry);
			existingNodes++;

		}
	}
	public HashEntry getFirst(K key){
		int index=hashFunction(key);
		return table[index];
	}

	

}