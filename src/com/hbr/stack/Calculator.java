package com.hbr.stack;
/**
 * ��ջʵ�ּ�����
 * @author huboren
 *
 */
public class Calculator {
	public static void main(String[] args) {
		
		String expression="10*2-5+6";
		CalStack numStack = new CalStack(10);
		CalStack operStack = new CalStack(10);
		int index=0;//����ɨ��
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
					//ֱ�Ӽ���ջ��
					operStack.push(ch);
				}
			}else {
				//��ջ
				//numStack.push(ch-48);//��Ϊchar a='1'=49
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
		//ʣ�µĽ�����ǰ�˳��
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
	//�ж�ջ�Ƿ���
	public boolean isFull() {
		return top==maxSize-1;
	}
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmply() {
		return top==-1;
	}
	//��ջ
	public void push(int value) {
		//�����ж�ջ�Ƿ�����
		if(isFull()) {
			System.out.println("ջ����");
			return;
		}
		stack[++top]=value;
	}
	//��ջ
	public int pop() {
		if(isEmply()) {
			throw  new RuntimeException("ջ�ǿյģ�������˼");
		}
		int value=stack[top];
		top--;
		return value;
	}
	//����ջ
	public void listStack() {
		if(isEmply()) {
			System.out.println("ջ�ǿյģ��޷�����");
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("ջstack[%d]=%d\n",i,stack[i]);
		}
	}
	
	//����ջ������
	public int peek() {
		return stack[top];
	}
	//������������ȼ������ȼ�Խ�ߣ�ֵ��Խ��
	public int priority(int oper) {
		if(oper=='*'||oper=='/') {
			return 1;
		}else if(oper=='+'||oper=='-') {
			return 0;
		}
		return -1;//��ʾ���Ϸ�
	}
	//�ж��ǲ���һ�������
	public boolean isOper(char ch) {
		return ch=='*'||ch=='/'||ch=='+'||ch=='-';
	}
	//���㷽��
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