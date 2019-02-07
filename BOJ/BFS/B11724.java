import java.util.*;
public class B11724 {
	static ArrayList<Integer> con[];
	static int visit[], dist[];
	static int N, M, count;
	
	static void bfs(Queue<Integer> que, int numb) {
		if(visit[numb]==0) {
			count++;
			que.offer(numb);
			while(!que.isEmpty()) {
				int temp = que.poll();
				visit[temp] = 1;
				for(int i : con[temp]) {
					if(visit[i]==0) {
						visit[i] = 1;
						que.offer(i);
					}	
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		con = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			con[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= M; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			con[u].add(v);
			con[v].add(u);
		}
		
		visit = new int[N+1];
		dist = new int[N+1];
		Queue<Integer> que = new LinkedList<Integer>();
		
		visit[1] = 0;
		dist[1] = 0;
		
		count = 0;
		
		for(int i = 1; i <=N; i++) {
			bfs(que, i);
		}
		
		System.out.println(count);
		

		
		/*
		while(!que.isEmpty()) {
			int temp = que.poll();
			visit[temp] = 1;
			System.out.println(temp);

			for(int i : con[temp]) {
				if(visit[i]==0) {
					visit[i] = 1;
					
					//dist[i] = dist[temp]+1;
					que.offer(i);
				}	
			}
		}
		*/

		
	}

}
