package model;

public class HashTable<K,V> {


	private HashEntry<K,V>[] table;

	private int existingNodes;

	public static int DEFAULT_SIZE=10;
	public HashTable(){
		table = new HashEntry[DEFAULT_SIZE];
		this.existingNodes=0;

	}


	public int hashFunction(K key){
		int hashCode;
		hashCode = key.hashCode();
		return Math.abs(hashCode) % table.length;
	}

	public void add(K key, V value){
		int index= hashFunction(key); //O(1)
		HashEntry<K,V> newEntry= new HashEntry<>(key, value); //O(1)
		HashEntry<K,V> current=table[index]; //O(1)
		if(current==null){//O(1)
			table[index]=newEntry;//O(1)

		}else{
			while(current.getNext()!=null){//O(n)

				current=current.getNext(); //O(n-1)
			}

			current.setNext(newEntry);//O(1)
			newEntry.setPrev(current);//O(1)
			newEntry.setNext(null);//O(1)
		}
		this.existingNodes++;//O(1)
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
				HashEntry<K,V> current = table[i].getNext();

				while (current != null) {

					elements.append("\t").append(current.getValue().toString()).append("\n");
					current = current.getNext();
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

	public HashEntry<K,V>[] getElementsAsArray2(){

		HashEntry<K,V>[]  allElements = new HashEntry[this.existingNodes];
		int j = 0;
		for(int i = 0; i < table.length; i++) {
			if (table[i] != null) {

				allElements[j] = new HashEntry<>(table[i].getKey(),table[i].getValue());
				j++;
				HashEntry<K,V> current = table[i].getNext();
				while (current != null) {

					allElements[j] = new HashEntry<>(current.getKey(),current.getValue());
					current = current.getNext();

					j++;
				}

			}

		}

		return allElements;
	}

	public String showArray2(){
		String msg = "";

		HashEntry<K,V>[] allElements = getElementsAsArray2();

		if(allElements.length != 0) {
			for(HashEntry<K,V> element : allElements){
				if(element != null){
					msg += "\n\t" + element.getValue().toString() ;
				}
				else {
					msg += "\n\n\tnull";

				}

			}

		}
		else {

			msg += "\n\tEMPTY";
		}
		msg += "\n\t" + allElements.length;


		return msg;

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


