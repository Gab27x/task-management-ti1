package model;

public class HashTable<K,V> {


	private HashEntry<K,V>[] table;
	private int existingNodes;

	public static int DEFAULT_SIZE=10;
	public HashTable(){
		table = new HashEntry[DEFAULT_SIZE];
		this.existingNodes=0;
	}

	public HashTable(int size){
		setDefaultSize(size);
		table = new HashEntry[DEFAULT_SIZE];

	}

	public int hashFunction(K key){
		int hashCode;
		hashCode = key.hashCode();
		return Math.abs(hashCode) % table.length;
	}
	public void add(K key, V value){
		int index= hashFunction(key);
		HashEntry<K,V> newEntry= new HashEntry<>(key, value);
		HashEntry<K,V> current=table[index];
		if(current==null){
			table[index]=newEntry;
			existingNodes++;
		}else{
			while(current.getNext()!=null){

				current=current.getNext();
			}
			current.setNext(newEntry);
			newEntry.setPrev(current);
			newEntry.setNext(null);
			existingNodes++;
		}

	}
	public HashEntry<K,V> getFirst(K key){
		if(table==null){
			return null;
		}
		int index= hashFunction(key);
		return table[index];

	}

	public V getValue(K key){
		if(table==null){
			return null;
		}
		int index= hashFunction(key);
		return table[index].getValue();

	}

	public HashEntry<K,V> find(K key){

		int index= hashFunction(key);
		HashEntry<K,V> current=table[index];
		while(current!=null){
			if(current.getKey().equals(key)){
				return current;
			}
			current=current.getNext();
		}

		return null;


	}

	public V findValue(K key){
		int index= hashFunction(key);
		HashEntry<K,V> current=table[index];
		while(current!=null){
			if(current.getKey().equals(key)){
				return current.getValue();
			}
			current=current.getNext();
		}

		return null;


	}

	public void delete(K key, V value) {
		int index = hashFunction(key);
		HashEntry<K, V> current = table[index];

		while (current != null) {
			if (current.getKey().equals(key) && current.getValue().equals(value)) {
				if (current.getPrev() != null) {
					current.getPrev().setNext(current.getNext());
				}
				if (current.getNext() != null) {
					current.getNext().setPrev(current.getPrev());
				}
				if (current == table[index]) {
					table[index] = current.getNext();
				}
				current.setNext(null);
				current.setPrev(null);
				this.existingNodes --;
				return;
			}
			current = current.getNext();
		}
	}


	public boolean isEmpty(){
		return this.existingNodes == 0;
	}

	public String showTable(){
		StringBuilder elements = new StringBuilder();

		for(int i=0;i< table.length;i++) {
			if (table[i] != null) {
				elements.append("\t").append(table[i].getValue().toString()).append("\n");
				while (table[i].getNext() != null) {
					table[i] = table[i].getNext();
					elements.append("\t").append(table[i].getValue().toString()).append("\n");
				}

			}
		}
		if(elements.toString().isEmpty()){
			return """
            \t╔════════════════════╗
            \t║   ANY TASKS ADDED  ║
            \t╚════════════════════╝
            """;

		}
		else {
			return elements.toString();
		}


	}

	public int getDefaultSize() {
		return DEFAULT_SIZE;
	}

	public void setDefaultSize(int defaultSize) {
		this.DEFAULT_SIZE = defaultSize;
	}

	public int getExistingNodes() {
		return existingNodes;
	}

	public void setExistingNodes(int existingNodes) {
		this.existingNodes = existingNodes;
	}

	public HashEntry<K, V>[] getTable() {
		return table;
	}

	public void setTable(HashEntry<K, V>[] table) {
		this.table = table;
	}
}