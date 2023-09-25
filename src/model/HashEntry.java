import java.util.ArrayList;
public class HashEntry<K,V> {

	private K key;
	private V value;
	private DoubleLinkedList<HashEntry> list;

	public HashEntry(K key, V value) {

		this.key = key;
		this.value = value;
		this.list=new DoubleLinkedList<>();
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

	public DoubleLinkedList<HashEntry> getList() {
		return list;
	}

	public void setList(DoubleLinkedList<HashEntry> list) {
		this.list = list;
	}
}