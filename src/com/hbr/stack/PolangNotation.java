package com.hbr.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后缀表达式做的计算器
 * @author huboren
 *
 */
public class PolangNotation {
public static void main(String[] args) {
	//(3+4)*5-6 -->3 4 + 5 * 6 -
	String suffixExpression="3 4 + 5 * 6 -";
	ArrayList<String> arrayList = add(suffixExpression);
	System.out.println(arrayList);
	int calculator = calculator(arrayList);
	System.out.println(calculator);
	
}
//定义一个方法，依次将数字和符号放入ArrayList中
public static ArrayList<String> add(String suffixExpression) {
	String[] splits = suffixExpression.split(" ");
	ArrayList<String> arrayList = new ArrayList<String>();
	for(String split:splits) {
		arrayList.add(split);
	}
	return arrayList;
}
//完成对方法的运算
public static int calculator(List<String> arrayList) {
	Stack<String> stack = new Stack<String>();
	int res=0;
	for(String list:arrayList) {
		//使用的是正则表达式，判断是否是数字,如果是数，直接入栈
		if(list.matches("\\d")) {
			stack.push(list);
		}else {
			int num2=Integer.parseInt(stack.pop());
			int num1=Integer.parseInt(stack.pop());
			if(list.equals("+")) {
				res=num1+num2;
			}else if(list.equals("*")) {
				res=num1*num2;
			}else if(list.equals("/")) {
				res=num1/num2;
			}else if(list.equals("-")){
				res=num1-num2;
			}else {
				throw new RuntimeException("运算符不对");
			}
			stack.push(String.valueOf(res));
		}
	}
	return Integer.parseInt(stack.pop());
}
}
