package com.hbr.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ��׺���ʽ���ļ�����
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
//����һ�����������ν����ֺͷ��ŷ���ArrayList��
public static ArrayList<String> add(String suffixExpression) {
	String[] splits = suffixExpression.split(" ");
	ArrayList<String> arrayList = new ArrayList<String>();
	for(String split:splits) {
		arrayList.add(split);
	}
	return arrayList;
}
//��ɶԷ���������
public static int calculator(List<String> arrayList) {
	Stack<String> stack = new Stack<String>();
	int res=0;
	for(String list:arrayList) {
		//ʹ�õ���������ʽ���ж��Ƿ�������,���������ֱ����ջ
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
				throw new RuntimeException("���������");
			}
			stack.push(String.valueOf(res));
		}
	}
	return Integer.parseInt(stack.pop());
}
}
