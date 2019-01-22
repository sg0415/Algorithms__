import java.util.*;

public class List {
	private Node headerNode;
	private Node tailNode;
	private int size = 0;
	
	public List(){
		headerNode = new Node(null);
		tailNode = new Node(null);
		this.headerNode.setNextNode(tailNode);
		this.tailNode.setPrevNode(headerNode);	
	}
	
	public Node getIndexNode(int index) {
		Node temp = null;
		temp = headerNode.getNextNode();		
		for(int i = 1; i <= index-1; i++) {
			temp = temp.getNextNode();
		}
		return temp; 
	}
	public Node getHeaderNode() {
		return headerNode;
	}
	public Node getTailNode() {
		return tailNode;
	}
	public int getSize() {
		return size;
	}
	
	public void addNode(Object data) {
		Node nextNode = new Node(data);
		
		(tailNode.getPrevNode()).setNextNode(nextNode);
		nextNode.setPrevNode(tailNode.getPrevNode());
		tailNode.setPrevNode(nextNode);
		nextNode.setNextNode(tailNode);
		size++;
	}
	
	public void insertNode(int index, Object data) {
		Node temp = this.getIndexNode(index);
		Node nextNode = new Node(data);
		
		nextNode.setPrevNode(temp);
		nextNode.setNextNode(temp.getNextNode());
		temp.getNextNode().setPrevNode(nextNode);
		temp.setNextNode(nextNode);
		size++;
	}
	public void removeNode(int index) {
		Node temp = getIndexNode(index);
		
		temp.getPrevNode().setNextNode(temp.getNextNode());
		temp.getNextNode().setPrevNode(temp.getPrevNode());
		temp = null;
		size--;
	}
	
	public void print() {
		Node temp = null;
		temp = headerNode.getNextNode();
		for(int i = 0; i <= size-1; i++) {
			System.out.print("\t"+temp.getNodeData());
			temp = temp.getNextNode();
		}
		System.out.println("");
	}
}
