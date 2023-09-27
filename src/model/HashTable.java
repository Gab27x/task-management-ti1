package model;

public class HashTable<K,V> {

	private HashEntry<K,V>[] table;
	private int existingNodes;

	private  int defaultSize=10;
	public HashTable(){
		table = new HashEntry[defaultSize];

		this.existingNodes=0;
	}

	public HashTable(int size){
		defaultSize=size;
		table = new HashEntry[defaultSize];

	}

	public int hashFunction(K key){
		Integer hashCode= key.hashCode();
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
				return;
			}
			current = current.getNext();
		}
	}


	public boolean isEmpty(){
		int counter=0;
        for (HashEntry<K, V> kvHashEntry : table) {
            if (kvHashEntry == null) {
                counter++;
            }

        }
		if(counter==table.length){
			return true;
		}

		return false;
	}

	public int getDefaultSize() {
		return defaultSize;
	}

	public void setDefaultSize(int defaultSize) {
		this.defaultSize = defaultSize;
	}

	public int getExistingNodes() {
		return existingNodes;
	}

	public void setExistingNodes(int existingNodes) {
		this.existingNodes = existingNodes;
	}



}