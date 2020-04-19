package com.hbr.recursion;
/**
 * 用递归来实现迷宫找路的问题
 * @param args
 */
public class MiGong {
public static void main(String[] args) {
	int[][] map=new int[8][7];
	for(int i=0;i<7;i++) {
		map[0][i]=1;
		map[7][i]=1;
	}
	for(int i=0;i<8;i++){
		map[i][0]=1;
		map[i][6]=1;
	}
	map[3][1]=1;
	map[3][2]=1;
	for(int i=0;i<8;i++) {
		for(int j=0;j<7;j++) {
			System.out.print(map[i][j]+" ");
		}
		System.out.println();
	}
	System.out.println("走路");
	setWay(map, 1, 1);
	for(int i=0;i<8;i++) {
		for(int j=0;j<7;j++) {
			System.out.print(map[i][j]+" ");
		}
		System.out.println();
	}
}
/**
 * i和j代表开始的地方
 * @param map
 * @param i
 * @param j
 * @return 约定：0代表没走过，1代表是墙，2代表已经走过了，3代表是个死路,路线是下》右》上》左
 */
public static boolean setWay(int[][] map,int i,int j) {
	if(map[6][5]==2) {
		return true;
	}else {
		if(map[i][j]==0) {
			map[i][j]=2;
			if(setWay(map, i+1, j)) {
				return true;
			}else if(setWay(map, i, j+1)) {
				return true;
			}else if(setWay(map, i-1, j)) {
				return true;
			}else if(setWay(map, i, j-1)) {
				return true;
			}else {
				map[i][j]=3;
				return false;
			}
				
				
		}else {
			return false;
		}
	}
}
}
