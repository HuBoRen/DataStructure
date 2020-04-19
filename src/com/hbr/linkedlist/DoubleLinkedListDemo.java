package com.hbr.linkedlist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		HeroNode1 heroNode = new HeroNode1(1, "胡");
		HeroNode1 heroNode2 = new HeroNode1(2, "古");
		HeroNode1 heroNode3 = new HeroNode1(3, "月");
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.addNode(heroNode2);
		doubleLinkedList.addNode(heroNode);
		doubleLinkedList.addNode(heroNode3);
		doubleLinkedList.listDoubleNode();
		doubleLinkedList.delDouble(2);
		System.out.println("********");
		doubleLinkedList.delDouble(1);
		doubleLinkedList.listDoubleNode();
		doubleLinkedList.delDouble(2);
		doubleLinkedList.listDoubleNode();
		doubleLinkedList.delDouble(3);
		doubleLinkedList.listDoubleNode();
	}
}
class DoubleLinkedList{
	
	HeroNode1 head=new HeroNode1(0, "");
	public HeroNode1 getHead() {
		return head;
	}
	public void addNode(HeroNode1 heroNode) {
		HeroNode1 temp=head;
		while(true) {
			if(temp.next==null) {
				break;
			}
			temp=temp.next;
		}
		temp.next=heroNode;
		heroNode.pre=temp;
	}
	public void listDoubleNode() {
		HeroNode1 temp=head.next;
		while(true) {
			if(head.next==null) {
				System.out.println("双向链表为空");
			}
			if(temp==null) {
				break;
			}
			System.out.println(temp);
			temp=temp.next;
		}
	}
	public void delDouble(int no) {
		HeroNode1 temp=head.next;
		if(head.next==null) {
			System.out.println("这是一个空的双向链表");
		}
		while(true) {
			if(temp==null) {
				System.out.println("没有找到待删除结点");
				break;
			}
			if(temp.no==no) {
				temp.pre.next=temp.next;
				if(temp.next!=null) {
				temp.next.pre=temp.pre;
				}
				break;
			}
			temp=temp.next;
		}
	}
}
class HeroNode1{
	int no;
	String name;
	HeroNode1 next;
	HeroNode1 pre;

	@Override
	public String toString() {
		return "HeroNode1 [no=" + no + ", name=" + name + "]";
	}

	public HeroNode1(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
}