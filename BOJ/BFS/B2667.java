import java.util.*;
import java.io.*;

public class B2667 {
	static int list[][];
	static int N;
	static int visit[];
	static LinkedList<Integer> con[];
	static ArrayList<Integer> sort;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		list = new int[N+1][N+1];
		
		int max = N*N;
		visit = new int[max+1];
		
		for(int i = 1; i <= N; i++) {
			String temp = br.readLine();
			for(int j = 1; j <= N; j++) {
				list[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j-1)));
				}
		}
		
		con = new LinkedList[max+1];
		for(int i = 1; i<=max; i++) {
			con[i] = new LinkedList();
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		sort = new ArrayList<Integer>();
		
		for(int i = 1; i <= max; i++) {
			int X = (i-1)/N + 1;
			int Y = (i-1)%N + 1;
			
			if(list[X][Y] == 1) {
				if(X < N && list[X+1][Y] ==1)	con[i].add(i+N);
				if(X > 1 && list[X-1][Y] ==1)	con[i].add(i-N);
				if(Y < N && list[X][Y+1] ==1)	con[i].add(i+1);
				if(Y > 1 && list[X][Y-1] ==1)	con[i].add(i-1);
			}else {
				visit[i] = 0;
			}
		}
		int count = 0;
		for(int i = 1 ; i <= max; i++) {
			int X = (i-1)/N + 1;
			int Y = (i-1)%N + 1;
			int test = 0;
			
			if(list[X][Y] == 1 && visit[i] == 0) {
				que.add(i);
				count++;
				while(!que.isEmpty()) {
					int temp = que.poll();
					visit[temp] = 1;
					test++;
					for(int j : con[temp]) {
						int tX = (i-1)/N + 1;
						int tY = (i-1)%N + 1;
						if(list[tX][tY] == 1 && visit[j] == 0) {
							visit[j] = 1;
							que.add(j);
						}
					}
				}
			sort.add(test);
			}
		}
		System.out.println(count);
		Collections.sort(sort);
		for(int x : sort) {
			System.out.println(x);
		}
	}

}
