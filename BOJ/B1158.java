import java.util.*;

public class B1158 {
	static LinkedList<Integer> list;
	static int[] J;
	static int N, M, count, num;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		J = new int[N];
		
		list = new LinkedList();
		
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		count = M-1;
		num = 0;

		while(!list.isEmpty()) {
			J[num++] = list.remove(count);
			
			count += (M-1);
			
			if(count >= list.size() && list.size()!=0) {
				count %= list.size();
			}


		}
		System.out.print("<");
		for (int i = 0; i < N-1; i++) {
			System.out.print(J[i]+", ");
		}
		System.out.print(J[N-1]);
		System.out.println(">");
	}

}
