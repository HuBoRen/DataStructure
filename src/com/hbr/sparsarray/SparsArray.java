package com.hbr.sparsarray;

public class SparsArray {
public static void main(String[] args) {
	int[][] chessArr=new int[11][11];
	chessArr[1][2]=1;
	chessArr[2][3]=2;
	chessArr[3][3]=2;
	//���ԭ����
	System.out.println("���ԭ����");
	for(int[] arr2:chessArr) {
		for(int data:arr2) {
			System.out.printf("%d\t",data);
		}
		System.out.println();
	}
	
	//����ά����ת����ϡ������
	int sum=0;
	for(int i=0;i<chessArr.length;i++) {
		for(int j=0;j<chessArr[i].length;j++) {
			if(chessArr[i][j]!=0) {
				sum++;
			}
		}
	}
	//System.out.println(sum);
	System.out.println("����ά����ת����ϡ������");
	int[][] arr3=new int[sum+1][3];
//	arr3[0][0]=11;
//	arr3[0][1]=11;
//	arr3[0][2]=sum;
	for(int i=0;i<chessArr.length;i++) {
			arr3[0][0]=chessArr.length;
			arr3[0][1]=chessArr[i].length;
			arr3[0][2]=sum;
		
	}
	int count=0;//������0��
	for(int i=0;i<chessArr.length;i++) {
		for(int j=0;j<chessArr[i].length;j++) {
			if(chessArr[i][j]!=0) {
				count++;
				arr3[count][0]=i;
				arr3[count][1]=j;
				arr3[count][2]=chessArr[i][j];
			}
			
		}
	}
	System.out.println("�õ�ϡ������Ϊ����");
	for(int[] arr4:arr3) {
		for(int arr5:arr4) {
			System.out.printf("%d\t",arr5);
		}
		System.out.println();
	}
	System.out.println("��ϡ������ת���ɶ�ά����");
	int[][] chessArr6=new int[arr3[0][0]][arr3[0][1]];
	//System.out.println(arr3.length);
//	for(int i=0;i<arr3.length )
	for(int i=1;i<arr3.length;i++) {
		chessArr6[arr3[i][0]][arr3[i][1]]=arr3[i][2];
	}
	for(int[] arr7:chessArr6) {
		for(int arr8:arr7) {
			System.out.printf("%d\t",arr8);
		}
		System.out.println();
	}
}

}
