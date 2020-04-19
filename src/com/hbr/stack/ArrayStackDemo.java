package com.hbr.stack;

import java.util.Scanner;

/**
 * ʹ��������ģ��ջ
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
		System.out.println("show:����");
		System.out.println("exit:�˳�");
		System.out.println("pop:��ջ");
		System.out.println("add:��ջ");
		System.out.println("������");
		key=scanner.next().charAt(0);
		switch(key) {
		case 's':
			arrayStack.listStack();
			break;
		case 'a':
			System.out.println("������������ӵ�ֵ");
			int value=scanner.nextInt();
			arrayStack.push(value);
			break;
		case 'p':
			try {
				int pop = arrayStack.pop();
				System.out.println("��ջԪ��Ϊ"+pop);
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
			System.out.printf("ջstack[%d]=%d",i,stack[i]);
		}
	}
}
