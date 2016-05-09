package others;

class Father {
	static String name = "father_hello";
	
	{
		System.out.println("father non static block");
	}
	static {
		System.out.println("father static block");
	}

	public Father() {
		System.out.println("father construction");
	}
	public void output(){
		System.out.println(name);
		
	}
}

class Child extends Father {
	static String name = "Child_hello";
	{
		System.out.println("Child non static block");
	}
	static {
		System.out.println("Child static block");
	}

	public Child() {
		System.out.println("Child construction");
	}
	public void output(){
		System.out.println(name);
	}
}

public class Test2 {
	public static void main(String[] args) {
//		Father f = new Child();
//		f.output();
		
		int a = 32;
		System.out.println(a>>32);
	}

}
