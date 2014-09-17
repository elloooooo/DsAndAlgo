package basicAlgorithm.selectImp;


public class Client {

	public static void main(String[] args) {
		int[] dataSet = {2,4,6,9,10,1,0};
		/*MaxOrMin maxOrMin = new MaxOrMin();
		maxOrMin.setData(dataSet);
		maxOrMin.getMax();
		maxOrMin.printSelectedDate();
		maxOrMin.getMin();
		maxOrMin.printSelectedDate();
		
		MaxAndMin maxAndMin = new MaxAndMin();
		maxAndMin.setData(dataSet);
		maxAndMin.getMaxAndMin();
		maxAndMin.printSelectedDate();*/
		
		RandomizedSelect randomizedSelect = new RandomizedSelect();
		randomizedSelect.setData(dataSet);
		int i = 7;
		randomizedSelect.randomizedSelect(0,6,i);
		System.out.print("µÚ"+i+"¸öÔªËØ");
		randomizedSelect.printSelectedDate();
	}

}
