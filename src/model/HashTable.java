import java.util.ArrayList;

public class HashTable<K,V> {


	private ArrayList<DoubleLinkedList<HashEntry<K,V>>> table;
	private int size;


	public HashTable() {
		this.table= new ArrayList<>();


	}
	/**
	 * Hash function designed to convert key into table index
	 * @param key
	 * @return
	 */
	private int hashFunction(K key){
		int hashCode = key.hashCode();
		return Math.abs(hashCode) % table.size();

	}



	/**
	 *Method created to add a new hash entry into the hash table, managing collisions
	 * @param key
	 * @param value
	 */
	public void add(K key,V value) {
		HashEntry<K,V> newEntry= new HashEntry<>(key, value);
		int index = hashFunction(key);
		//Si la lista esta vacia entonces lo añada al principio
		if(table.get(index).isEmpty()){
			table.get(index).addFirst(newEntry);
			size++;
		}else if(!table.get(index).isEmpty()){ //en caso de que ya este llena lo añade al final
			table.get(index).addLast(newEntry);
			size++;
		}

	}

	/**
	 * Method designed to search an element in the hash table
	 *
	 * @param key
	 * @param value
	 */
	public NodeDoubleLinkedList search(K key, V value) {
		HashEntry objective= new HashEntry<>(key, value);
		int index= hashFunction(key);
		return table.get(index).find(objective);

	}

	/**
	 *
	 * @param key
	 */
	public HashEntry delete(T key) {
		// TODO - implement HashTable.delete
		throw new UnsupportedOperationException();
	}

	public boolean isEmpty() {
		// TODO - implement HashTable.isEmpty
		throw new UnsupportedOperationException();
	}

	public int getSize() {
		return this.size;
	}

}