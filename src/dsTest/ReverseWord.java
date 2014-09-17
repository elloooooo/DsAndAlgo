package dsTest;


/**
 * @author elloooooo
 * ��ת�����е��ʵ�˳�򣬵��ǵ����ڲ�����ĸ˳�򲻱�
 * 
 * ����˼·���Ƚ�����������ת��Ȼ�󽫵����ٷ�תһ��
 * 
 * ����ʵ��ͨ��һ��ջ�ṹ�����ַ�����ȫ����ջ��ջ���ﵽ������ӷ�ת
 * 
 * Ȼ���ٴ���ջ����������ո���ȫ����ջ��֮�������ջ���Դ˽�ÿһ�����ʵ�˳��ת
 *
 */
public class ReverseWord {
	char[] data;
	private char[] stack;
	private int top;

	public ReverseWord(String str) {
		data = str.toCharArray();
		this.stack = new char[str.toCharArray().length];
		this.top=-1;
	}

	public void push(char i) {
		top++;
		this.stack[top] = i;
	}
	
	public char pop(){
		char element = this.stack[top];
		this.stack[top] = 0;
		top--;
		return element;
	}

	public boolean isStackEmpty(){
		return top==-1;
	}
	
	public String reverse(){
		for(int i=0;i<this.data.length;i++){
			this.push(this.data[i]);
		}
		
		int j = 0;
		while(!this.isStackEmpty()){
			this.data[j] = this.pop();
			j++;
		}
		
		StringBuffer stringBuffer = new StringBuffer();
		
		for(int i=0;i<this.data.length;i++){
			//���Ԫ�ز��ǿո����ջ
			if(this.data[i]!=32){
				this.push(this.data[i]);
				//���Ԫ�����������һ��Ԫ�أ���ջ��Ԫ��ȫ����ջ
				if(i==this.data.length-1){
					while(!this.isStackEmpty()){
						stringBuffer.append(this.pop());
					}
				}
			}else{
				//���Ԫ���ǿո���ջ��Ԫ��ȫ����ջ
				while(!this.isStackEmpty()){
					stringBuffer.append(this.pop());
				}
				stringBuffer.append(this.data[i]);
			}
		}
		
		
		return stringBuffer.toString();
	}
	
	public static void main(String[] args) {
		String str = "Tom is a student.";
		ReverseWord r = new ReverseWord(str);
		System.out.println(r.reverse());
	}

}
