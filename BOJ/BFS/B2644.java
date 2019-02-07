import java.util.*;

public class B2644 {
	static int Num, start, end, m;
	static int[] visit, depth;
	static ArrayList<Integer> con[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		Num = scan.nextInt();
		
		start = scan.nextInt();
		end = scan.nextInt();
		
		m = scan.nextInt();
		
		con = new ArrayList[Num+1];
		for(int i = 1; i <= Num; i++) {
			con[i] = new ArrayList();
		}
		
		for(int i = 1; i <= m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			con[a].add(b);
			con[b].add(a);
		}
		
		visit = new int[Num+1];
		depth = new int[Num+1];
		Queue<Integer> q = new LinkedList<Integer>(); 
		
		q.offer(start);
		depth[start] = 0;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			if(visit[temp]==0) {
				visit[temp] =1;
				
				for(int i : con[temp]) {
					if(visit[i] == 0) {
						depth[i] = depth[temp]+1;
						q.offer(i);
					}
				}
			}
			
		}
		if(visit[end] == 0) System.out.println("-1");
		else		System.out.println(depth[end]);
		
	}

}
