
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List myLinkedList = new List();
		
		//��� �߰�
		myLinkedList.addNode("D");
		myLinkedList.addNode("A");
		myLinkedList.addNode("N");
		myLinkedList.addNode("I");
		myLinkedList.addNode("E");
		myLinkedList.addNode("L");
		myLinkedList.addNode("��");
		myLinkedList.print();
		
		//5��° ��� �ڿ� ����
		myLinkedList.insertNode(5, "��");
		myLinkedList.print();
		
		//6��° ��� ����
		myLinkedList.removeNode(6);
		myLinkedList.print();
	}

}
