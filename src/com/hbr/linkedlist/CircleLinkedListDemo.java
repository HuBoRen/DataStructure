package com.hbr.linkedlist;
/**
 * 环形链表
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
	 * 添加方法
	 * @param nums 添加几个小孩
	 */
	public void addBoy(int nums) {
		if(nums<1) {
			System.out.println("链表至少需要一个");
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
	//遍历方法
	public void listCirCleLinkedList() {
		if(first==null) {
			System.out.println("环形链表为空");
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
	 * @param startNo 小孩一开始的地方
	 * @param count   数几次
	 * @param nums    一共多少个孩子
	 */
	public void countBoy(int startNo,int count,int nums) {
		if(startNo<1||first==null||startNo>nums) {
			System.out.println("参数不合法");
		}
		//一个辅助节点
		Boy temp=first;
		while(true) {
			if(temp.next==first) {
				break;
			}
			temp=temp.next;
		}
		//数小孩之前先找到开始节点
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
			//将要出圈的小孩子
			System.out.println(first);
			first=first.next;
			temp.next=first;
		}
		System.out.println("最后出圈的孩子"+first);
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