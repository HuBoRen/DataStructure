package com.hbr.linkedlist;

import java.util.Stack;

/**
 * ˳������
 * 
 * @author huboren
 *
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		HeroNode heroNode = new HeroNode(1, "��");
		HeroNode heroNode2 = new HeroNode(2, "��");
		HeroNode heroNode3 = new HeroNode(3, "��");
		SingleLinkedList singleLinkedList = new SingleLinkedList();
//	singleLinkedList.add(heroNode3);
//	singleLinkedList.add(heroNode2);
//	singleLinkedList.add(heroNode);
		singleLinkedList.addOrder(heroNode3);
		singleLinkedList.addOrder(heroNode2);
		singleLinkedList.addOrder(heroNode);
		System.out.println("ԭ��");
//		singleLinkedList.addOrder(heroNode);
		singleLinkedList.list();
		System.out.println("Ȼ��");
		reserveList(singleLinkedList.getHead());
//		System.out.println("************");
//		HeroNode heroNode4 = new HeroNode(3, "��yue");
//		singleLinkedList.updateNode(heroNode4);
//		singleLinkedList.list();
//		System.out.println("****");
//		singleLinkedList.del(1);
//		singleLinkedList.del(2);
//		singleLinkedList.del(3);
//		singleLinkedList.list();
//		singleLinkedList.addOrder(heroNode3);
//		singleLinkedList.addOrder(heroNode2);
//		singleLinkedList.addOrder(heroNode);
//		int length = SingleLinkedListDemo.getLength(singleLinkedList.getHead());
//		singleLinkedList.list();
//		System.out.println(length);
//		HeroNode lastIndex = SingleLinkedListDemo.findLastIndex(singleLinkedList.getHead(), 3);
//		System.out.println(lastIndex);
	}
	public static int getLength(HeroNode head) {
		if(head.next==null) {
			return 0;
		}
		HeroNode temp=head.next;
		int count=0;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	public static HeroNode findLastIndex(HeroNode head,int lastIndex) {
		if(head.next==null) {
			return null;
		}
		HeroNode temp=head.next;
		int size=getLength(head)-lastIndex;
		for(int i=0;i<size;i++) {
			temp=temp.next;
		}
		return temp;
	}
	//����ջ�Ƚ�������ص�
	public static void reserveList(HeroNode head) {
		if(head.next==null) {
			return;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode temp=head.next;
		while(temp!=null) {
			stack.push(temp);
			temp=temp.next;
		}
		//���б���
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
	}
}

class SingleLinkedList {
	private HeroNode head = new HeroNode(0, "");

	public HeroNode getHead() {
		return head;
	}

	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
	}

	public void list() {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	// ���ձ��˳�����
	public void addOrder(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			} else if (temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println("������������");
		} else {

			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	public void updateNode(HeroNode newHeroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
		} else {
			System.out.println("û���ҵ�");
		}
	}

	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.println("û���ҵ���Ԫ��");
		}
	}
}

class HeroNode {
	int no;
	String name;
	HeroNode next;

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

}