import java.util.ArrayList;
import java.util.List;

public class HashTable<K,V> {


	private ArrayList<HashEntry<K,V>> table;
	private int size;





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
	 * 	Method designed to add  a new hash entry into the table
	 * @param key
	 * @param value
	 */

	public void add(K key, V value){
		HashEntry newEntry= new HashEntry(key, value);
		add(key,newEntry);

	}



	/**
	 *
	 * @param newHashEntry
	 */
	public void add(K key,HashEntry newHashEntry) {
		int index=hashFunction(key);
		ArrayList<HashEntry<K, V>> bucket = table[index];

		for (HashEntry<K, V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				entry.setValue(newHashEntry.getValue());
				return;
			}
		}

		bucket.add(new Entry<>(key, value));
		size++;


	}

	/**
	 *
	 * @param key
	 */
	public HashEntry search(T key) {
		// TODO - implement HashTable.search
		throw new UnsupportedOperationException();
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