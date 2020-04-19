package com.hbr.queue;

import java.util.Scanner;

/**
 * 环形数组
 * @author huboren
 *
 */
public class CircleArrQueueDemo {
public static void main(String[] args) {
	CircleArrayQueus queus = new CircleArrayQueus(4);
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

class CircleArrayQueus{
	private int maxSize;//数组的最大长度
	private int front;//队列头
	private int rear;//指的是
	private int[] arr;
	public CircleArrayQueus(int maxSize){
		this.maxSize=maxSize;
		arr=new int[maxSize];
	}
	//判断队列是否满了
	public boolean isFull() {
		return (rear+1)%maxSize==front;
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
		arr[rear]=value;
		rear=(rear+1)%maxSize;
	}
	//出队列,并获取当前队列头值
	public int getQueue() {
		if(isExist()) {
			throw new RuntimeException("数组为空");
		}
		int value=arr[front];
		front=(front+1)%maxSize;
		return value;
	}
	//显示队列所有值
	public void showQueue() {
		if(isExist()) {
			System.out.println("数组为空~~");
			return;
		}
		for (int i = 0; i < front+size(); i++) {
			System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
		}
	}
	//当前队列的有效数据的个数
	public int size() {
		return (rear+maxSize-front)%maxSize;
	}
	//显示头数据，不出队列
	public int headQueue() {
		if(isExist()) {
			throw new RuntimeException("数组为空");
		}
		return arr[front];
	}
	}
