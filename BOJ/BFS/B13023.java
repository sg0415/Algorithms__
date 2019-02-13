import java.util.*;
import java.io.*;

public class B13023 {
	static int K, V, E;
	static ArrayList<Integer> con[];
	static int visit[];
	static boolean dist[];
	static boolean check = true;
	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.offer(start);
		visit[start] = 1;
		dist[start] = true;
		
		while(!que.isEmpty()) {

			int temp = que.poll();
			for(int i : con[temp]) {
				
				if(visit[i] == 0) {
					que.offer(i);
					visit[i] = 1;
					dist[i] = !dist[temp];
				}
				if(dist[i] == dist[temp]) {
					check = false;
					return;
				}

			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			con = new ArrayList[V+1];
			
			for(int t = 1; t <=V; t++) {
				con[t] = new ArrayList();
			}
			
			for(int j = 1; j <= E; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				con[a].add(b);
				con[b].add(a);
			}
			visit = new int[V+1];
			dist = new boolean[V+1];

			for(int t = 1 ; t <= V ; t++) {
				if(!check) {
					break;
				}
				if(visit[t] == 0) {
					bfs(t);
				}
			}
			
			System.out.println(check ? "YES" : "NO");
			check = true;
		}
	}

}
