package dsTest;

public class Fibonacci {
	public long fibonacci(int n){
		if(n==0)return 0;
		if(n==1)return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public long fibonacciI(int n){
		if(n==0)return 0;
		if(n==1)return 1;
		
		long f1 = 0;
		long f2 = 1;
		long fn = 0;
		for(int i=2;i<n;i++){
			fn = f1+f2;
			f2 = f1;
			f1 = fn;
		}
		
		return fn;
	}
	
	public static void main(String[] args) {
		int n = 3;
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibonacci(n));
	}

}
