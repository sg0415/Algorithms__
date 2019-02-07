import java.util.*;

public class B5014 {
		static int F, S, G, U, D;
		static int con[];
		static int visit[];
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		F = scan.nextInt();
		S = scan.nextInt();
		G = scan.nextInt();
		U = scan.nextInt();
		D = scan.nextInt();
		
		con = new int[F+1];
		
		for(int i = 1; i<= F; i++) {
			con[i] = Integer.MAX_VALUE;
		}
		
		/*
		for(int i = 1; i<= F-U; i++) {
			con[i].add(i+U);
		}
		for(int i = F; i > D; i--) {
			con[i].add(i-D);
		}
		 */
		Queue<Integer> que = new LinkedList<Integer>();
		visit = new int[F+1];
		
		que.offer(S);
		con[S] = 0;
		visit[S] = 0;
		while(!que.isEmpty()) {
			int f = que.poll();
			
			if(f == G)	break;
			
			//Up
			if(f+U <= F && U >0 && con[f+U] == Integer.MAX_VALUE) {
				con[f+U] = con[f] + 1;
				if(f+U == G) break;
				que.offer(f+U);
			}
				
			//Down
			if(f-D >= 1 && D >0 && con[f-D] == Integer.MAX_VALUE) {
				con[f-D] = con[f] + 1;
				if(f-D == G) break;
				que.offer(f-D);
			}
		}
		
		if(con[G] == Integer.MAX_VALUE)	System.out.println("use the stairs");
		else				System.out.println(con[G]);
	}

}
