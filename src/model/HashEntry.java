package model;
public class HashEntry<K,V> {

	private K key;
	private V value;
	private HashEntry<K,V> next;
	private HashEntry<K,V> prev;




	public HashEntry(K key, V value) {
		this.key = key;
		this.value = value;
		this.next=null;
		this.prev=null;
	}



	public K getKey() {
		return key;
	}


	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public HashEntry<K,V> getNext() {
		return next;
	}

	public void setNext(HashEntry<K,V> next) {
		this.next = next;
	}

	public HashEntry<K,V> getPrev() {
		return prev;
	}

	public void setPrev(HashEntry<K,V> prev) {
		this.prev = prev;
	}


	@Override
	public String toString() {
		return "HashEntry{" +
				"key=" + key +
				", value=" + value.toString() +
				'}';
	}
}