package others;
import java.util.Scanner;

public class Main {
	/**
	 * 有几盏灯亮
	 */
	public void countLightsOn(){
		Scanner cin = new Scanner(System.in);
		int num;
		while (cin.hasNext()) {
			num = cin.nextInt();
			if(num<1||num>65535){
				System.out.println("非法输入");
				continue;
			}
			int[] lights = new int[num];
			
			for(int i=0;i<num;i++){
				for(int j=i;j<num;j+=(i+1)){
					lights[j] ^= 1; 
				}
			}
			
			int sum = 0;
			for(int k=0;k<num;k++){
				if(lights[k]!=0){
					sum ++;
				}
			}
			System.out.println(sum);
		}
	}
	
	
	
	/**
	 * 精灵王子逃脱问题
	 */
	public void elfPrince(){
		Scanner cin = new Scanner(System.in);
		int M,S,T;
		
		while (cin.hasNext()) {
			M = cin.nextInt();
			S = cin.nextInt();
			T = cin.nextInt();
			
			if(S==0){
				System.out.println("Yes "+"0");
				continue;
			}
			if(T==0&&S!=0){
				System.out.println("No "+"0");
				continue;
			}
			
			int time=0,s=0;
			while(s<S&&time<T){
				if(M>=10){
					s += 60;
					time++;
					continue;
				}else{
					if(S-s<=34||((T-time-1)*4<(10-M))){
						s+=17;
						time++;
						continue;
					}else{
						time++;
						M += 4;
					}
				}
				
			}
			
			if(S-s<=0){
				System.out.println("Yes "+time);
			}else{
				System.out.println("No "+s);
			}
		}
	}
	public static void main(String[] args) {
		Main m = new Main();
		m.elfPrince();
	}
}
