package com.hbr.queue;

import java.util.Scanner;
/**
 * �������
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
		System.out.println("s����ʾ����");
		System.out.println("e���˳�����");
		System.out.println("a����Ӷ���");
		System.out.println("g��ȡ������");
		System.out.println("h���鿴ͷ����");
		key=scanner.next().charAt(0);
		switch (key) {
		case 's':
			queus.showQueue();
			break;
		case 'a':
			System.out.println("�����һ����");
			int i = scanner.nextInt();
			queus.addQueue(i);
			break;
		case 'g':
			int queue = queus.getQueue();
			System.out.printf("ȡ��������%d\n",queue);
			break;
		case 'h':
			int queue1 = queus.headQueue();
			System.out.printf("����ͷ������%d\n",queue1);
			break;
		case 'e':
			scanner.close();
			loop=false;
			break;
		default:
			break;
		}
		
	}
	System.out.println("�����˳�");
}
}
class ArrayQueus{
	private int maxSize;//�������󳤶�
	private int front;//����ͷ
	private int rear;//����β
	private int[] arr;
	public ArrayQueus(int maxSize){
		this.maxSize=maxSize;
		arr=new int[maxSize];
		front=-1;
		rear=-1;
	}
	//�ж϶����Ƿ�����
	public boolean isFull() {
		return rear==maxSize-1;
	}
	//�ж϶����Ƿ�û������
	public boolean isExist() {
		return rear==front;
	}
	//������ݵ���������
	public void addQueue(int value) {
		if(isFull()) {
			System.out.println("�����Ѿ�����");
			return;
		}
		arr[++rear]=value;
	}
	//������,����ȡ��ǰ����ͷֵ
	public int getQueue() {
		if(isExist()) {
			throw new RuntimeException("����Ϊ��");
		}
		return arr[++front];
	}
	//��ʾ��������ֵ
	public void showQueue() {
		if(isExist()) {
			System.out.println("����Ϊ��~~");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	//��ʾͷ���ݣ���������
	public int headQueue() {
		if(isExist()) {
			throw new RuntimeException("����Ϊ��");
		}
		return arr[front+1];
	}
}

