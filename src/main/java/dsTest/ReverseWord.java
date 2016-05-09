package dsTest;


/**
 * @author elloooooo
 * 逆转句子中单词的顺序，但是单词内部的字母顺序不变
 * 
 * 总体思路是先将句子整个反转，然后将单词再反转一遍
 * 
 * 本次实现通过一个栈结构，让字符数组全部如栈出栈，达到这个句子反转
 * 
 * 然后再次入栈，如果遇到空格，则全部出栈，之后继续入栈，以此将每一个单词的顺序反转
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
			//如果元素不是空格就入栈
			if(this.data[i]!=32){
				this.push(this.data[i]);
				//如果元素是序列最后一个元素，则栈中元素全部出栈
				if(i==this.data.length-1){
					while(!this.isStackEmpty()){
						stringBuffer.append(this.pop());
					}
				}
			}else{
				//如果元素是空格，则栈中元素全部出栈
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
