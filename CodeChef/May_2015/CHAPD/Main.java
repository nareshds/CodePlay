import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long T = Long.parseLong(br.readLine());
		while(T-- > 0){
			String[] input = br.readLine().split(" ");
			long A = Long.parseLong(input[0]);
			long B = Long.parseLong(input[1]);
			List<Long> primeFactsB = new ArrayList();
			primeFactsB = getPrimeFactors(B);
						
			for(int i = 0; i < primeFactsB.size(); i++){
				if(A%primeFactsB.get(i) != 0){
					System.out.println("No");
					break;
				}
				if(i == primeFactsB.size() - 1) System.out.println("Yes");
			}
		}
	}
	
	public static List getPrimeFactors(long num){
		List<Long> primeFactors = new ArrayList();
		int size = primeFactors.size();
		while(num%2 == 0){
			if(size == 0) primeFactors.add(2l);
			num = num/2;
			size = primeFactors.size();
		}
		for(long i = 3l; i <= Math.sqrt(num); i=i+2){
			while(num%i== 0){
				size = primeFactors.size();
				if(size > 0 && primeFactors.get(size-1) != i)primeFactors.add(i);
				else if(size == 0) primeFactors.add(i);
				num = num/i;
			}
		}
		if(num > 2) primeFactors.add(num);
		return primeFactors;
	}
}
