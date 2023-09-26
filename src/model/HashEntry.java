package model;
public class HashEntry<K,V> {

	private K key;
	private V value;
	private HashEntry next;
	private HashEntry prev;




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

	public HashEntry getNext() {
		return next;
	}

	public void setNext(HashEntry next) {
		this.next = next;
	}

	public HashEntry getPrev() {
		return prev;
	}

	public void setPrev(HashEntry prev) {
		this.prev = prev;
	}
}