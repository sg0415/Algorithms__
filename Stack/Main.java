
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack myStack = new Stack(5);
		
		myStack.push(5);
		myStack.printStack();
		myStack.push(4);
		myStack.push(3);
		myStack.push(2);
		myStack.push(1);
		myStack.printStack();
		myStack.pop();
		myStack.printStack();
		
	}

}
