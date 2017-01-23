package test;

import java.util.Random;

public class RandomProduce {
	public static int getRandom(int begin, int end){
		Random ran = new Random();
		return ran.nextInt(end)+begin;
	}
//	public static void main(String[] args) {
//		for(int i = 0;i<300;i++) {
//			System.out.println(getRandom(1, 1));
//		}
//	}
}
