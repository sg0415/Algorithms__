
public class Node {
	private Object nodeData;
	private Node prevNode;
	private Node nextNode;
	
	public Node(Object data) {
		this.nodeData = data;
	}
	
	public Object getNodeData() {
		return this.nodeData;
	}
	public Node getPrevNode() {
		return this.prevNode;
	}
	public Node getNextNode() {
		return this.nextNode;
	}
	public void setNodeData(Object data) {
		this.nodeData = data;
	}
	public void setPrevNode(Node prev) {
		this.prevNode = prev; 
	}
	public void setNextNode(Node next) {
		this.nextNode = next;
	}
}
