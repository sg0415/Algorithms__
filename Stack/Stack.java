
public class Stack {
	private int top;
	private int[] stack;
	private int size;
	
	public Stack(int size) {
		stack = new int[size];
		top = -1;
		this.size = size;
	}

	public boolean empty() {
		if(stack == null)	return true;
		else	 			return false; 
	}
	
	public int pop() {
		if(top >=0 && top < size) {
			System.out.println(stack[top] + " pop.");
			return stack[top--];
		}else {
			System.out.println("빈 스택");
			return -1;
		}
	}
	
	public int peek() {
		System.out.println(stack[top] + " peek. ");
		return 0;
	}
	
	public int push(int item) {
		if(top < size-1) {
			stack[++top] = item;
			System.out.println(stack[top] + " push. ");
			return item;

		}else {
			System.out.println("사이즈 초과");
			return -1;
		}
	}
	public void printStack() {
		for(int i = 0; i < top+1; i++) {
			System.out.print(stack[i]+ "\t");
		}
		System.out.println("");
	}
	public int search(int index) {
		return 0;
	}
}
