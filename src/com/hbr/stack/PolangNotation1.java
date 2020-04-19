package com.hbr.stack;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转化成后缀表达式
 * @author huboren
 *
 */
public class PolangNotation1 {
public static void main(String[] args) {
	String expression="1+((2+3)*4)-5";
	List<String> middleList = toMiddleList(expression);
	System.out.println(middleList);
	List<String> suffixList = toSuffixList(middleList);
	System.out.println(suffixList);
	
}
//将中缀表达式转换成后缀表达式
public static List<String> toSuffixList(List<String> ls){
	//定义两个栈，或者一个栈，一个集合
	Stack<String> oper = new Stack<String>();
	ArrayList<String> arrayList = new ArrayList<String>();
	for(String item:ls) {
		if(item.matches("\\d+")) {
			arrayList.add(item);
		}else if(item.equals("(")){
			oper.push(item);
		}else if(item.equals(")")) {
			while(!oper.peek().equals("(")) {
				arrayList.add(oper.pop());
			}
			oper.pop();
		}else {
			while(oper.size()!=0&&Operation.getValue(item)<=Operation.getValue(oper.peek())) {
				arrayList.add(oper.pop());
			}
			oper.push(item);
		}
	}
	while(oper.size()>0) {
		arrayList.add(oper.pop());
	}
	return arrayList;
}
//将中缀表达式转成对应的list
public static List<String> toMiddleList(String expression){
	ArrayList<String> arrayList = new ArrayList<String>();
	int i=0;//遍历指针
	String str="";//用于拼接
	char c;//用于接收
	while(i<expression.length()) {
		//判断是否是一个数,如果char在48到57之间就是个数
		if((c=expression.charAt(i))<48||(c=expression.charAt(i))>57) {
			arrayList.add(c+"");
			i++;
		}else {
			//所以要考虑多位数的情况
			while(i<expression.length()&&(c=expression.charAt(i))>=48&&(c=expression.charAt(i))<=57) {
				str+=c;
				i++;
			}
			arrayList.add(str);
			str="";
		}
		
	}
	return arrayList;
}
}
//符号优先级的类
class Operation{
	private static int ADD=1;//+
	private static int SUB=1;//-
	private static int MUL=2;//*
	private static int DIV=2;//
	public static int getValue(String oper) {
		int res=0;
		switch (oper) {
		case "*":
		res= MUL;	
			break;
		case "/":
			res= DIV;	
			break;
		case "+":
			res= ADD;	
			break;
		case "-":
			res= SUB;	
			break;
		default:
			System.out.println("错了");
			break;
		}
		return res;
	}
	
}
