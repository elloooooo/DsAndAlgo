package dsTest;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 */

public class GasStation {
	/**
	 * @param gas
	 * @param cost
	 * @return
	 * 
	 * 次解法应该就是暴力解法吧
	 * 
	 * 从第一个站出发，如果可以到达第二个站，则开往下一个，如果不能则从第二个站出发，重复上述过程
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int startStation = 0;//始发站
		int curStation = 0;//当前所在站
		int visitedStation = 0;//已经驶过的站数
		int gasLeft = 0;//剩余油量
		while(visitedStation<gas.length){
			
			gasLeft = gasLeft + gas[curStation] - cost[curStation];
			if(gasLeft>=0){//还有剩余油量
				curStation++;
				visitedStation++;
				if(curStation==gas.length){//如果当前站超过了gas数组的下标，则置为0，相当于循环到开头
					curStation = 0;
				}
			}else{//到不了下一个站
				startStation++;
				curStation = startStation;
				visitedStation =0;
				gasLeft = 0;
				if(startStation == gas.length){//如果已经检测过了最后一个站，仍没能跳出循环，则说明到不了！
					return -1;
				}
			}
			
		}
		
		return startStation;
	}

	public static void main(String[] args) {
		int[] gas = {1,2};
		int[] cost = {2,1};
		GasStation g = new GasStation();
		System.out.println(g.canCompleteCircuit(gas, cost));
	}

}
