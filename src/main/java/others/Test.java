package others;

abstract class ListNode{
	public void echo(){
		System.out.println("hah");
	}
	public abstract void echo1();
}

class ListNodeImp extends ListNode{
	@Override
	public void echo(){
		
	}
	
	@Override
	public void echo1() {
		final String a = "1233";
		final String b = "123"+a.length(); 
		System.out.println(a==b);
	}
}

public class Test {
		
		public static int k=0;
		public static Test t1 = new Test("t1");
		public static Test t2 = new Test("t2");
		public static int i=print("i");
		public static int n = 99;
		public int j=print("j");
		
		{
			print("�����");		
		}
		static{
			print("��̬��");
		}
		
		public Test(String str){
			System.out.println((++k)+":"+str+"	i="+i+"	n="+n);
			++i;++n;
		}
		
		public static int print(String str){
			System.out.println((++k)+":"+str+"	i="+i+"	n="+n);
			++n;
			return ++i;
		}

		public static void main(String[] args) {
			Test t= new Test("init");
		}


}



