package practise13;

public class MyStackTest {
	public static void main(String [] args){
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(17);
		stack.push(5);
		stack.push(123);
		stack.push(25);
		stack.push(12);
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
		stack.push(83);
		System.out.println(stack);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		
	}
}
