package com.hbr.queue;

import java.util.Scanner;

/**
 * ��������
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

class CircleArrayQueus{
	private int maxSize;//�������󳤶�
	private int front;//����ͷ
	private int rear;//ָ����
	private int[] arr;
	public CircleArrayQueus(int maxSize){
		this.maxSize=maxSize;
		arr=new int[maxSize];
	}
	//�ж϶����Ƿ�����
	public boolean isFull() {
		return (rear+1)%maxSize==front;
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
		arr[rear]=value;
		rear=(rear+1)%maxSize;
	}
	//������,����ȡ��ǰ����ͷֵ
	public int getQueue() {
		if(isExist()) {
			throw new RuntimeException("����Ϊ��");
		}
		int value=arr[front];
		front=(front+1)%maxSize;
		return value;
	}
	//��ʾ��������ֵ
	public void showQueue() {
		if(isExist()) {
			System.out.println("����Ϊ��~~");
			return;
		}
		for (int i = 0; i < front+size(); i++) {
			System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
		}
	}
	//��ǰ���е���Ч���ݵĸ���
	public int size() {
		return (rear+maxSize-front)%maxSize;
	}
	//��ʾͷ���ݣ���������
	public int headQueue() {
		if(isExist()) {
			throw new RuntimeException("����Ϊ��");
		}
		return arr[front];
	}
	}
