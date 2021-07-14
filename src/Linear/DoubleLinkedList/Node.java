public class Node {
	private Node prev;
	private Node next;
	private Object data;
	public Node(Object data) {
		this.data = data;
		prev = null;
		next = null;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object item) {
		data= item;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node link) {
		this.prev = link;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node link) {
		this.next = link;
	}
}
