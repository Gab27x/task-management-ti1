public class Node_BST {

	private Node left;
	private Node right;
	private Activity activity;
	private String key;

	/**
	 * 
	 * @param activity
	 */
	public Node_BST(Activity activity) {
		// TODO - implement Node_BST.Node_BST
		throw new UnsupportedOperationException();
	}

	public Node getLeft() {
		return this.left;
	}

	/**
	 * 
	 * @param left
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return this.right;
	}

	/**
	 * 
	 * @param right
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	public Activity getActivity() {
		return this.activity;
	}

	/**
	 * 
	 * @param activity
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public String getKey() {
		return this.key;
	}

	/**
	 * 
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

}