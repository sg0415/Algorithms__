import java.util.*;
public class B1697 {
	static int dot[] = new int[100001];
	static int visit[] = new int[100001];
	static int N, K;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		
		
		for(int i = 1; i <= 100000; i++) {
			dot[i] = 0;
		}
		
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.offer(N);
		visit[N] = 0;
		
		while(!que.isEmpty()) {
			int temp = que.poll();
			dot[temp] = 1;
			
			if(temp-1 >= 0 && dot[temp-1] ==0) {
				visit[temp-1] = visit[temp]+1;
				dot[temp-1] = 1;
				if(temp-1 == K) break;
				que.offer(temp-1);
			}
			
			if(temp+1 <= 100000 && dot[temp+1] == 0) {
				visit[temp+1] = visit[temp]+1;
				dot[temp+1] = 1;
				if(temp+1 == K) break;
				que.offer(temp+1);
			}
			
			if(temp*2 <= 100000 && dot[temp*2] == 0) {
				visit[temp*2] = visit[temp]+1;
				dot[temp*2] = 1;
				if(temp*2 == K) break;
				que.offer(temp*2);
			}
		}
		
		System.out.println(visit[K]);
		
	}

}
