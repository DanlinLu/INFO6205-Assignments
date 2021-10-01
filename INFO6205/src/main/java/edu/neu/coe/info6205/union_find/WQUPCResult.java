package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class WQUPCResult {
	
	public static int count(int n) {
		UF_HWQUPC qupc = new UF_HWQUPC(n);
		
		Random rand = new Random();
		
		int num = 0;
		while(qupc.components() != 1) {
			int rand_int1 = rand.nextInt(n);
	        int rand_int2 = rand.nextInt(n);
	        if (qupc.find(rand_int1) != qupc.find(rand_int2)) {
	        	qupc.union(rand_int1, rand_int2);
	        }
	        num++;
		}
		return num;
	}
	
	public static void main(String args[]) {
		int[] n = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};
		int iteration = 1000;
		double sum = 0;
		for (int j : n) {
		for (int i = 0; i < iteration; i++) {
			sum += count(j);
		}
		double res = sum/iteration;
		//System.out.println("n: "+j+", "+"average iterations: "+res);
		System.out.println(res);
		}
	}
	

}
