
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List myLinkedList = new List();
		
		//노드 추가
		myLinkedList.addNode("D");
		myLinkedList.addNode("A");
		myLinkedList.addNode("N");
		myLinkedList.addNode("I");
		myLinkedList.addNode("E");
		myLinkedList.addNode("L");
		myLinkedList.addNode("♥");
		myLinkedList.print();
		
		//5번째 노드 뒤에 삽입
		myLinkedList.insertNode(5, "♥");
		myLinkedList.print();
		
		//6번째 노드 제거
		myLinkedList.removeNode(6);
		myLinkedList.print();
	}

}
