import java.io.*;
import java.util.*;

public class B1012_ {
	static int[][] list;
	static ArrayList<Integer> con[];
	static int[] visit;
	static int T, M, N, K, count;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		//테스트케이스
		T = scan.nextInt();
		
		for(int n = 0; n < T; n++) {
			//배추밭 가로길이 M, 세로길이 N, 배추 위치 개수 K(정점?)
			M = scan.nextInt();
			N = scan.nextInt();
			K = scan.nextInt();
			
			list = new int[N+1][M+1];
			
			for(int i = 1; i <= K; i++) {
				int X = scan.nextInt();
				int Y = scan.nextInt();
				
				list[Y+1][X+1]++;
			}
			
			int max = N*M;
			con = new ArrayList[max+1];
			visit = new int[max+1];

			for(int j = 1; j <= max; j++) {
				con[j] = new ArrayList();
				
				int X = (j-1)/M + 1;
				int Y = (j-1)%M + 1;
				
				if(list[X][Y] != 0) {
					if(X > 1 && list[X-1][Y] !=0) {
						con[j].add(j-M);
					}
					if(Y < M && list[X][Y+1] !=0) {
						con[j].add(j+1);
					}
					if(X < N && list[X+1][Y] !=0) {
						con[j].add(j+M);
					}
					if(Y > 1 && list[X][Y-1] !=0) {
						con[j].add(j-1);
					}
				}
			}
			
			Queue<Integer> que = new LinkedList<Integer>();
			visit[1] = 0;
			count = 0;
			
			//bfs
			for(int i = 1; i <= max; i++) {
				int X = (i-1)/M + 1;
				int Y = (i-1)%M + 1;
				
				if(visit[i] == 0 && list[X][Y] != 0) {
					count++;
					que.offer(i);
					while(!que.isEmpty()) {
						int temp = que.poll();
						visit[temp] =1;
						
						for(int j : con[temp]) {
							if(visit[j] == 0) {
								visit[j] = 1;
								list[X][Y] = 1;
								que.offer(j);
							}
						}
					}
				}
			}
		System.out.println(count);
		}
	}

}
