package com.hbr.queue;

import java.util.Scanner;
/**
 * 数组队列
 * @author huboren
 *
 */
public class ArrayQueueDemo {
public static void main(String[] args) {
	ArrayQueus queus = new ArrayQueus(3);
	char key;
	Scanner scanner = new Scanner(System.in);
	
	boolean loop=true;
	while(loop) {
		System.out.println("s：显示队列");
		System.out.println("e：退出程序");
		System.out.println("a：添加队列");
		System.out.println("g：取出数据");
		System.out.println("h：查看头数据");
		key=scanner.next().charAt(0);
		switch (key) {
		case 's':
			queus.showQueue();
			break;
		case 'a':
			System.out.println("请输出一个数");
			int i = scanner.nextInt();
			queus.addQueue(i);
			break;
		case 'g':
			int queue = queus.getQueue();
			System.out.printf("取出的数据%d\n",queue);
			break;
		case 'h':
			int queue1 = queus.headQueue();
			System.out.printf("队列头的数据%d\n",queue1);
			break;
		case 'e':
			scanner.close();
			loop=false;
			break;
		default:
			break;
		}
		
	}
	System.out.println("程序退出");
}
}
class ArrayQueus{
	private int maxSize;//数组的最大长度
	private int front;//队列头
	private int rear;//队列尾
	private int[] arr;
	public ArrayQueus(int maxSize){
		this.maxSize=maxSize;
		arr=new int[maxSize];
		front=-1;
		rear=-1;
	}
	//判断队列是否满了
	public boolean isFull() {
		return rear==maxSize-1;
	}
	//判断队列是否没有数据
	public boolean isExist() {
		return rear==front;
	}
	//添加数据到队列里面
	public void addQueue(int value) {
		if(isFull()) {
			System.out.println("队列已经满了");
			return;
		}
		arr[++rear]=value;
	}
	//出队列,并获取当前队列头值
	public int getQueue() {
		if(isExist()) {
			throw new RuntimeException("数组为空");
		}
		return arr[++front];
	}
	//显示队列所有值
	public void showQueue() {
		if(isExist()) {
			System.out.println("数组为空~~");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	//显示头数据，不出队列
	public int headQueue() {
		if(isExist()) {
			throw new RuntimeException("数组为空");
		}
		return arr[front+1];
	}
}

