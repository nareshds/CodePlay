import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			String[] input = br.readLine().split(" ");
			long A = Long.parseLong(input[0]);
			long B = Long.parseLong(input[1]);
			List<Long> primeFactsA = new ArrayList();
			List<Long> primeFactsB = new ArrayList();
			primeFactsA = getPrimeFactors(A);
			primeFactsB = getPrimeFactors(B);
			/*for(int i = 0; i < primeFactsA.size(); i++){
				System.out.print(primeFactsA.get(i)+" ");
			}
			System.out.println();
			for(int i = 0; i < primeFactsB.size(); i++){
				System.out.print(primeFactsB.get(i)+" ");
			}
			System.out.println();*/
			
			for(int i = 0; i < primeFactsB.size(); i++){
				long currFactor = primeFactsB.get(i);
				if(!primeFactsA.contains(currFactor)){
					System.out.println("No");
					break;
				}
				if(i == primeFactsB.size() - 1) System.out.println("Yes");
			}
		}
	}
	
	public static List getPrimeFactors(long num){
		List<Long> primeFactors = new ArrayList();
		while(num%2 == 0){
			primeFactors.add(2l);
			num = num/2;
		}
		for(long i = 3; i <= Math.sqrt(num); i=i+2){
			while(num%i== 0){
				primeFactors.add(i);
				num = num/i;
			}
		}
		if(num > 2) primeFactors.add(num);
		return primeFactors;
	}
}
