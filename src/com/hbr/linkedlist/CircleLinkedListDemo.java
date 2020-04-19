package com.hbr.linkedlist;
/**
 * ��������
 * @author huboren
 *
 */
public class CircleLinkedListDemo {
public static void main(String[] args) {
	CircleLinkedList list=new CircleLinkedList();
	list.addBoy(5);
	list.listCirCleLinkedList();
	list.countBoy(1, 2, 5);
}
}
class CircleLinkedList{
	Boy first;
	/**
	 * ��ӷ���
	 * @param nums ��Ӽ���С��
	 */
	public void addBoy(int nums) {
		if(nums<1) {
			System.out.println("����������Ҫһ��");
			return;
		}
		Boy temp=null;
		for(int i=1;i<=nums;i++) {
			Boy boy = new Boy(i);
			if(i==1) {
				first=boy;
				first.next=first;
				temp=first;
			}else {
				temp.next=boy;
				boy.next=first;
				temp=boy;
			}
		}
	}
	//��������
	public void listCirCleLinkedList() {
		if(first==null) {
			System.out.println("��������Ϊ��");
			return;
		}
		Boy temp=first;
		while(true) {
			System.out.println(temp);
			if(temp.next==first) {
				return;
			}
			temp=temp.next;
		}
		
	}
	/**
	 * 
	 * @param startNo С��һ��ʼ�ĵط�
	 * @param count   ������
	 * @param nums    һ�����ٸ�����
	 */
	public void countBoy(int startNo,int count,int nums) {
		if(startNo<1||first==null||startNo>nums) {
			System.out.println("�������Ϸ�");
		}
		//һ�������ڵ�
		Boy temp=first;
		while(true) {
			if(temp.next==first) {
				break;
			}
			temp=temp.next;
		}
		//��С��֮ǰ���ҵ���ʼ�ڵ�
		for(int i=1;i<=startNo-1;i++) {
			first=first.next;
			temp=temp.next;
		}
		while(true) {
			if(first==temp) {
				System.out.println(first);
				break;
			}
			for(int j=1;j<=count-1;j++) {
				first=first.next;
				temp=temp.next;
			}
			//��Ҫ��Ȧ��С����
			System.out.println(first);
			first=first.next;
			temp.next=first;
		}
		System.out.println("����Ȧ�ĺ���"+first);
	}
}
class Boy{
	int no;
	Boy next;
	@Override
	public String toString() {
		return "Boy [no=" + no + "]";
	}
	public Boy(int no) {
		super();
		this.no = no;
	}
	
}