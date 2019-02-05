import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static ArrayList<Integer>[] con;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		V = 7;
		E = 6;
		
		ArrayList<Integer>[] list;
		
		list = new ArrayList[V+1];
		
		for(int i = 1; i < V+1; i++) {
			list[i] = new ArrayList();
		}
		
		list[1].add(2);	
		list[1].add(3);	
		list[1].add(7);	
		list[2].add(4);	
		list[3].add(5);	
		list[3].add(6);	
		
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(1);

		
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.println(temp);
			int size = list[temp].size();
			
			for(int i = 0; i < size; i++) {
				q.offer(list[temp].get(i));
			}
		}
		
	}
}
