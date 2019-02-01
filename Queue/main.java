import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue(7);
		q.add("D");
		q.add("A");
		q.add("N");
		q.add("I");
		q.add("E");
		q.add("L");
		q.add("¢¾");
		
		q.printStack();
		System.out.println("peek : " + q.peek());
		q.printStack();

		System.out.println("poll : " + q.poll());
		q.printStack();

		q.remove("¢¾");
		q.printStack();
		
		q.add("¢½");
		q.printStack();


	}

}
