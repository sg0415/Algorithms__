import java.util.*;
import java.io.*;

public class B13549 {
	static int N, K;
	static int list[] = new int[100001];
	static int visit[] = new int[100001];
	static int dist[] = new int[100001];
	
	public static void bfs(int n) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		visit[n] = 1;
		dist[n] = 0;
		que.offer(n);
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			//System.out.println(cur);
			
			if(cur == K) {
				visit[cur] = 1;
				dist[K] = dist[cur];
				break;
			}
			if(cur*2 <= 100000 && visit[cur*2] != 1) {
				visit[cur*2] = 1;
				dist[cur*2] = dist[cur];
				que.offer(cur*2);
			}	
			
			if(cur-1 >=0 && visit[cur-1] != 1) {
				visit[cur-1] = 1;
				dist[cur-1] = dist[cur]+1;
				que.offer(cur-1);
			}
			
			if(cur+1 <= 100000 && visit[cur+1] != 1) {
				visit[cur+1] = 1;
				dist[cur+1] = dist[cur]+1;
				que.offer(cur+1);
			}
			

		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs(N);
		System.out.println(dist[K]);
		
	}

}
