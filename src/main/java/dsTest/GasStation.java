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
	 * �νⷨӦ�þ��Ǳ����ⷨ��
	 * 
	 * �ӵ�һ��վ������������Ե���ڶ���վ��������һ�������������ӵڶ���վ�������ظ���������
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int startStation = 0;//ʼ��վ
		int curStation = 0;//��ǰ����վ
		int visitedStation = 0;//�Ѿ�ʻ����վ��
		int gasLeft = 0;//ʣ������
		while(visitedStation<gas.length){
			
			gasLeft = gasLeft + gas[curStation] - cost[curStation];
			if(gasLeft>=0){//����ʣ������
				curStation++;
				visitedStation++;
				if(curStation==gas.length){//�����ǰվ������gas������±꣬����Ϊ0���൱��ѭ������ͷ
					curStation = 0;
				}
			}else{//��������һ��վ
				startStation++;
				curStation = startStation;
				visitedStation =0;
				gasLeft = 0;
				if(startStation == gas.length){//����Ѿ����������һ��վ����û������ѭ������˵�������ˣ�
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
