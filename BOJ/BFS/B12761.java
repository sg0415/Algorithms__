import java.util.*;
import java.io.*;
public class B12761 {
	static int A, B, N, M;
	static int visit[] = new int[100001];
	static int dist[] = new int[100001];
	
	public static void bfs(Queue<Integer> que, int visit[], int dist[]) {
		while(!que.isEmpty()) {
			int temp = que.poll();			
			if(temp == M) {
				break;
			}else {
				if(temp+1 <= 100000 && visit[temp+1]==0) {
					que.offer(temp+1);
					visit[temp+1] = 1;
					dist[temp+1] = dist[temp]+1;
				}
				if(temp-1 >= 0 && visit[temp-1]==0) {
					que.offer(temp-1);
					visit[temp-1] = 1;
					dist[temp-1] = dist[temp]+1;
				}			
				if(temp+A <= 100000 && visit[temp+A]==0) {
					que.offer(temp+A);
					visit[temp+A] = 1;
					dist[temp+A] = dist[temp]+1;
				}
				if(temp-A >= 0 && visit[temp-A]==0) {
					que.offer(temp-A);
					visit[temp-A] = 1;
					dist[temp-A] = dist[temp]+1;
				}
				if(temp+B <= 100000 && visit[temp+B]==0) {
					que.offer(temp+B);
					visit[temp+B] = 1;
					dist[temp+B] = dist[temp]+1;	
				}	
				if(temp-B >= 0 && visit[temp-B]==0) {
					que.offer(temp-B);
					visit[temp-B] = 1;
					dist[temp-B] = dist[temp]+1;
				}			
				if(temp*A <= 100000 && visit[temp*A]==0) {
					que.offer(temp*A);
					visit[temp*A] = 1;
					dist[temp*A] = dist[temp]+1;
				}	
				if(temp*B <= 100000 && visit[temp*B]==0) {
					que.offer(temp*B);
					visit[temp*B] = 1;
					dist[temp*B] = dist[temp]+1;
				}	
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.offer(N);
		visit[N] = 1;
		dist[N] = 0;
		bfs(que, visit, dist);
		
		System.out.println(dist[M]);
	}

}
