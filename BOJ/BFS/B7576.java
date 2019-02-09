import java.io.*;
import java.util.*;

public class B7576 {
	static int list[][];
	static ArrayList<Integer> con[];
	static int visit[], tomatoma[] , depth[];
	static int M, N, tomato, count;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//가로 : 열!!
		M = Integer.parseInt(st.nextToken());
		//세로 : 행 !!
		N = Integer.parseInt(st.nextToken());

		list = new int[N+1][M+1];
		tomato = 0;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				if(list[i][j] ==1) {
					tomato++;
				}
			}
		}
		int max = N*M;
		tomatoma = new int[tomato];
		con = new ArrayList[max+1];
		for(int i = 1; i <= max; i++) {
			con[i] = new ArrayList();
		}

		int numb = 0;

		Queue<Integer> que = new LinkedList<Integer>();

		for(int i = 1; i <= max; i++) {
			int X = (i-1)/M + 1;
			int Y = (i-1)%M + 1;
			
			if(list[X][Y] >= 0) {
				if(X < N && list[X+1][Y] >=0)	con[i].add(i+M);
				if(X > 1 && list[X-1][Y] >=0)	con[i].add(i-M);
				if(Y < M && list[X][Y+1] >=0)	con[i].add(i+1);
				if(Y > 1 && list[X][Y-1] >=0)	con[i].add(i-1);
				if(list[X][Y] == 1) {
					tomatoma[numb++] = i;
					que.add(i);
				}
			}
		}
		
		visit = new int[max+1];
		depth = new int[max+1];
		count = 0;
		
		while(!que.isEmpty()) {
			int temp = que.poll();
			
			if(visit[temp] == 0) {
				visit[temp] = 1;
				for(int j : con[temp]) {
					int tX = (j-1)/M + 1;
					int tY = (j-1)%M + 1;
					if(visit[j] ==0) {
						depth[j] = depth[temp]+1;
						list[tX][tY] = 1;
						que.add(j);
						count = depth[j];
					}
				}
			}
		}

		boolean test = true;
		
		for(int i = 1; i <=N; i++) {
			for(int j = 1; j <=M; j++) {
				if(list[i][j]==0) {
					count = -1;
					test = false;
					break;
				}
			}
			if(!test) break;
		}
		System.out.println(count);
		
		
	}
}
