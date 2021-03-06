import java.util.*;

public class Queue {
	private LinkedList<String> myList;
	private int qSize;
	
	public Queue(int size) {
		myList = new LinkedList<String>();
		this.qSize = size;
	}
	
	public boolean empty() {
		if(myList.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean add(String s) {
		if(qSize <= myList.size()) {
			System.out.println("size �ʰ�");
			return false;
		}else {
			myList.addLast(s);
			return true;
		}
	}
	
	public String element() {
		return myList.getFirst();
	}
	
	public boolean offer(String s) {
		myList.addLast(s);
		return true;
	}
	
	public String peek() {
		if(myList == null) {
			return null;
		}else {
			return myList.getFirst();
		}
	}
	
	public String poll() {
			if(myList == null) {
				return null;
			}else {
				return myList.removeFirst();
			}
	}
	
	public String remove() {
		System.out.println("peek : " + myList.removeFirst());
		return "";
	}
	
	public String remove(String s) {
		myList.remove(s);
		return "";
	}
	
	public void printStack() {
		Iterator e = myList.iterator();
		
		while(e.hasNext()) {
			System.out.print(e.next()+"    ");
		}
		System.out.println("");
	}
}
