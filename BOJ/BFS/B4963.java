import java.util.*;
import java.io.*;

public class B4963 {
	static int w, h, count;
	static int list[][];
	static int visit[][];
	static int[] dx = {0,1,1,1,0,-1,-1,-1};	//위쪽부터 시계방향순
	static int[] dy = {-1,-1,0,1,1,1,0,-1};

	public static void bfs(Node n, Queue<Node> que) {
		que.offer(n);
		while(!que.isEmpty()) {
			Node temp = que.poll();
			for(int i = 0; i < 8; i ++) {
				int nX = temp.x + dx[i];
				int nY = temp.y + dy[i];
				if(nX < 0 || nY < 0 || nX > w || nY > h) {
					continue;
				}
				if(visit[nY][nX] == 1) {
					continue;
				}
				if(list[nY][nX] == 1) {
					visit[nY][nX] = 1;
					que.offer(new Node(nY, nX));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if(w == 0 || h == 0)	break;

			Queue<Node> que = new LinkedList<Node>();
			list = new int[h+1][w+1];
			visit = new int[h+1][w+1];
			count = 0;
			
			for(int i = 1; i <= h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= w; j++) {
					list[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i =1; i<=h; i++) {
				for(int j = 1; j<=w; j++) {
					if(list[i][j] == 1 && visit[i][j] == 0) {
						bfs(new Node(i,j), que);
						count++;
					}
				}
			}
			System.out.println(count);
		}

		
	}

}
/*
class Node{
	int x;
	int y;
	Node(int y, int x){
		this.y = y;
		this.x = x;
	}
}
*/