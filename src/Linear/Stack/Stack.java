public class Stack {
	private int top;
	private Object[] elements;
	
	Stack(int capacity){
		elements = new Object[capacity];
		top=-1;
	}
	void push(Object object) {
		if(isFull()) {
			System.out.println("System Overflow");
		}
		elements[++top]=object;
	}
	Object pop() {
		if(isEmpty()) {
			System.out.println("System Overflow");
			return null;
		}
		else {
			Object a = elements[top--];
			return a;
		}
	}
	int size() {
		return top+1;
	}
	boolean isFull() {
		return top+1 == elements.length;
	}
	boolean isEmpty(){
		return (top == -1);
	}
	Object Peek() {
		if(isEmpty()) {
			System.out.println("System Overflow");
			return null;
		}
		return elements[top];
	}
	static Stack DeepCopy(Stack stack) {
		if(stack == null) {
			return null;
		}
		Stack tempStack2 = new Stack(600);
		Stack tempStack3 = new Stack(600);
		while(!stack.isEmpty()) {
			tempStack3.push(stack.pop());
		}
		while(!tempStack3.isEmpty()) {
			stack.push(tempStack3.Peek());
			tempStack2.push(tempStack3.pop());
		}
		return tempStack2;
	}
}
