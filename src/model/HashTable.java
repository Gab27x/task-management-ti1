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



	/**
	 *
	 * @param key
	 * @param value
	 */
	public void add(K key,V value) {
		HashEntry<K,V> newEntry= new HashEntry<>(key, value);
		int index = hashFunction(key);

		for (HashEntry<K, V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				entry.s = value; // Actualizar el valor si la clave ya existe
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