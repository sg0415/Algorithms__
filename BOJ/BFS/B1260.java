import java.util.*;
import java.io.*;

public class B1260 {
	static int N, M, V;
	static int visit[];
	static ArrayList<Integer> con[];
	
	public static void bfs(int V) {
		//StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(V);
		visit[V] = 1;
		while(!que.isEmpty()) {
			int temp = que.poll();
			//sb.append(temp+" ");
			System.out.print(temp + " ");
			for(int i : con[temp]) {
				if(visit[i] == 0) {
					visit[i] = 1;
					que.offer(i);
				}
			}
		}
		//sb.deleteCharAt(sb.length()-1);
		//System.out.println(sb.toString());
	}
	
	public static void dfs(int V) {
		if(visit[V] == 1) {
			return;
		}
		visit[V] = 1;
		System.out.print(V+" ");
		for(int j : con[V]) {
			if(visit[j] == 0){
				dfs(j);
			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		con = new ArrayList[N+1];
		for(int i = 0; i <=N; i++) {
			con[i] = new ArrayList();
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			con[a].add(b);
			con[b].add(a);
		}
		for(int i = 1; i <= N; i++) {
			Collections.sort(con[i]);
		}
		
		visit = new int[N+1];
		dfs(V);
		System.out.println("");
		visit = new int[N+1];
		bfs(V);
		System.out.println("");
	}

}
