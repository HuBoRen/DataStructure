package com.hbr.stack;
/**
 * 用栈实现计算器
 * @author huboren
 *
 */
public class Calculator {
	public static void main(String[] args) {
		
		String expression="10*2-5+6";
		CalStack numStack = new CalStack(10);
		CalStack operStack = new CalStack(10);
		int index=0;//用于扫描
		int num1=0;
		int num2=0;
		int oper=0;
		int res=0;
		char ch;
		String key="";
		while(true) {
			ch=expression.substring(index, index+1).charAt(0);
			if(operStack.isOper(ch)) {
				if(!operStack.isEmply()) {
					if(operStack.priority(ch)<=operStack.priority(operStack.peek())) {
						 num1=numStack.pop();
						 num2=numStack.pop();
						 oper = operStack.pop();
						 res=numStack.cal(num1, num2, oper);
						 operStack.push(ch);
						numStack.push(res);
					}else{
						operStack.push(ch);
					}
				}else {
					//直接加入栈中
					operStack.push(ch);
				}
			}else {
				//数栈
				//numStack.push(ch-48);//因为char a='1'=49
				key+=ch;
				if(index==expression.length()-1) {
					numStack.push(Integer.parseInt(key));
				}else {
					if(operStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
					numStack.push(Integer.parseInt(key));
					key="";
					}
				}
			}
			index++;
			if(index>=expression.length()) {
				break;
			}
		}
		//剩下的结果就是按顺序
		while(true) {
			if(operStack.isEmply()) {
				break;
			}
			num1=numStack.pop();
			num2=numStack.pop();
			oper=operStack.pop();
			res=numStack.cal(num1, num2, oper);
			numStack.push(res);
			
		}
		System.out.println(res);
	}
}
class CalStack{
	private int top=-1;
	private int[] stack;
	private int maxSize;
	public CalStack(int maxSize){
		this.maxSize=maxSize;
		stack=new int[maxSize];
	}
	//判断栈是否满
	public boolean isFull() {
		return top==maxSize-1;
	}
	//判断栈是否为空
	public boolean isEmply() {
		return top==-1;
	}
	//入栈
	public void push(int value) {
		//首先判断栈是否满了
		if(isFull()) {
			System.out.println("栈满了");
			return;
		}
		stack[++top]=value;
	}
	//出栈
	public int pop() {
		if(isEmply()) {
			throw  new RuntimeException("栈是空的，不好意思");
		}
		int value=stack[top];
		top--;
		return value;
	}
	//遍历栈
	public void listStack() {
		if(isEmply()) {
			System.out.println("栈是空的，无法遍历");
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("栈stack[%d]=%d\n",i,stack[i]);
		}
	}
	
	//返回栈顶的数
	public int peek() {
		return stack[top];
	}
	//返回运算符优先级，优先级越高，值就越大
	public int priority(int oper) {
		if(oper=='*'||oper=='/') {
			return 1;
		}else if(oper=='+'||oper=='-') {
			return 0;
		}
		return -1;//表示不合法
	}
	//判断是不是一个运算符
	public boolean isOper(char ch) {
		return ch=='*'||ch=='/'||ch=='+'||ch=='-';
	}
	//计算方法
	public int cal(int num1,int num2,int oper) {
		int res=0;
		switch (oper) {
		case '*':
			res=num1*num2;
			break;
		case '/':
			res=num2/num1;
			break;
		case '+':
			res=num1+num2;
			break;
		case '-':
			res=num2-num1;
			break;
		default:
			break;
		}
		return res;
	}
	
}