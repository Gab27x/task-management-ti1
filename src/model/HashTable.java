
package model;
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
		int index= hashFunction(key);
		HashEntry newEntry= new HashEntry<>(key, value);
		 HashEntry current=table[index];
		if(current==null){
			table[index]=newEntry;
		}else{
			while(current!=null){
				if(current.getNext()==null){
					current.setNext(newEntry);
					newEntry.setPrev(current);
				}
				current=current.getNext();
			}
		}

	}
	public HashEntry getFirst(K key){
		int index= hashFunction(key);
		return table[index];

	}

	public HashEntry find(K key, V value){
		int index= hashFunction(key);
		HashEntry current=table[index];
		while(current!=null){
			if(current.getValue().equals(value)){
				return current;
			}
			current=current.getNext();
		}

		return null;


	}

	public void delete(K key, V value){
		HashEntry objective= new HashEntry<>(key, value);
		int index= hashFunction(key);
		HashEntry current= table[index];

		if(current.getValue()==objective){
			current.getNext().setPrev(null);
			current.setNext(null);
		}else{
			while(current!=null){
				if(current.getValue()==objective && current.getNext()!=null){
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
					current.setNext(null);
					current.setPrev(null);
				}else if(current.getValue()==objective && current.getNext()==null){
					current.getPrev().setNext(null);
					current.setPrev(null);

				}
				current=current.getNext();
			}
		}

	}

	public boolean isEmpty(){
		int counter=0;
		for(int i=0; i< table.length;i++){
			if (table[i]==null){
				counter++;
			}

		}
		if(counter== table.length){
			return true;
		}

		return false;
	}



}