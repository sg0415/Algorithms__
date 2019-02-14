import java.util.*;
import java.io.*;

public class B3055 {
	static int R, C;
	static Node S, D;
	static ArrayList<Node> W = new ArrayList<Node>();
	static char list[][];
	static int visit[][];
	static int dist[][];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	
	// . : 비어있음	D : 비버의 굴
	// * : 물		S : 고슴도치의 위치
	// X : 돌
	
	public static void bfs(Node start, ArrayList<Node> water) {
		Queue<Node> que = new LinkedList<Node>();
		que.offer(start);

		for(Node i : water) {
			que.offer(i);
		}

		visit[start.y][start.x] = 0;
		dist[start.y][start.x]= 0;
		
		//visit : 0 (미방문)
		//visit : -1 (물물물물)
		//visit : 1 (고슴도치)
		while(!que.isEmpty()) {
			Node cur = que.poll();
			int cy = cur.y;
			int cx = cur.x;
			for(int i = 0; i < 4; i++) {
				int ny = cy + dx[i];
				int nx = cx + dy[i];
				
				if(ny < 0 || nx < 0 || nx > C || ny > R) {
					continue;
				}
				if(list[ny][nx] == 'X') {
					continue;
				}
				
				if(list[cy][cx] == '*' && visit[ny][nx] != -1) {
					if(list[ny][nx] != 'D') {
						list[ny][nx] = '*';
						visit[ny][nx] = -1;
						que.offer(new Node(ny, nx));
					}
				}
				
				if((list[cy][cx] == '.' || list[cy][cx] =='S')&& visit[ny][nx] == 0) {
					if(list[ny][nx] == 'D') {
						dist[ny][nx]=dist[cy][cx]+1;
						return;
					}
					list[ny][nx] = 'S';
					visit[ny][nx] = 1;
					dist[ny][nx] = dist[cy][cx] + 1;
					que.offer(new Node(ny, nx));
				}
			}
			for(int i = 1; i <= R; i++) {
				for(int j = 1; j <= C; j++) {
					System.out.print(list[i][j]);
				}
				System.out.println("");
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		list = new char[R+1][C+1];
		visit = new int[R+1][C+1];
		dist = new int[R+1][C+1];
		
		for(int i = 1; i <= R; i++) {
			String s = br.readLine();
			for(int j = 1; j <= C; j++) {
				list[i][j] = s.charAt(j-1);
				if(list[i][j] == 'S') {
					S = new Node(i,j);
				}
				if(list[i][j] == 'D') {
					D = new Node(i,j);
				}
				if(list[i][j] == '*'){
					W.add(new Node(i,j));
				}
			}
		}

		bfs(S, W);
		/*
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				System.out.print(list[i][j]);
			}
			System.out.println("");
		}
			*/
		int ans = dist[D.y][D.x]; 
		System.out.println(ans !=0 ? ans : "KAKTUS");
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