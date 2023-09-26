public class HashEntry {

	private T key;
	private K value;

	public K getValue() {
		return this.value;
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(K value) {
		this.value = value;
	}

	public T getKey() {
		return this.key;
	}

	/**
	 * 
	 * @param key
	 */
	public void setKey(T key) {
		this.key = key;
	}

}