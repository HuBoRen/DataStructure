package com.hbr.stack;

import java.util.Scanner;

/**
 * 使用数组来模拟栈
 * @author huboren
 *
 */
public class ArrayStackDemo {
public static void main(String[] args) {
	ArrayStack arrayStack = new ArrayStack(4);
	Scanner scanner = new Scanner(System.in);
	char key;
	boolean loop=true;
	while(loop) {
		System.out.println("show:遍历");
		System.out.println("exit:退出");
		System.out.println("pop:出栈");
		System.out.println("add:入栈");
		System.out.println("请输入");
		key=scanner.next().charAt(0);
		switch(key) {
		case 's':
			arrayStack.listStack();
			break;
		case 'a':
			System.out.println("请输入你想添加的值");
			int value=scanner.nextInt();
			arrayStack.push(value);
			break;
		case 'p':
			try {
				int pop = arrayStack.pop();
				System.out.println("出栈元素为"+pop);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case 'e':
			loop=false;
			break;
		}
	}
}
}
class ArrayStack{
	private int top=-1;
	private int[] stack;
	private int maxSize;
	public ArrayStack(int maxSize){
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
			System.out.printf("栈stack[%d]=%d",i,stack[i]);
		}
	}
}
