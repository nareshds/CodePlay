import java.io.*;
import java.util.*;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int C = Integer.parseInt(input[1]);
			int position[] = new int[N];
			for(int i = 0; i < position.length; i++){
				position[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(position);
			int distance = binSearch(position, C);
			System.out.println(distance);
		}
	}
	
	public static int binSearch(int[] A, int c){
		int start = 0; int end = A[A.length-1]-A[0];
		while(start <= end){
			int mid = (start + end)/2;
			if(limit(c, A, mid) == 1){
				start = mid + 1;
			}else{
				end = mid -1;
			}
		}
		return end;
	}
	
	public static int limit(int c, int[] A, int distance){
		int placedCows = 1;
		int lastPosition = A[0];
		for(int i = 0; i < A.length; i++){
			if(A[i]-lastPosition < distance)
				continue;
            if(++placedCows == c) return 1;
            lastPosition = A[i];				
		}
		return 0;
	}	
}
