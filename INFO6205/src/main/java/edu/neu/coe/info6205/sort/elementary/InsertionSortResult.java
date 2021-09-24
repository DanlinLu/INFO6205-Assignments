package edu.neu.coe.info6205.sort.elementary;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

import edu.neu.coe.info6205.util.Benchmark_Timer;

public class InsertionSortResult {

	public static double ddoit(int N, int type) {
			InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
			Supplier<Integer[]> supplier = () -> arr(N,type);
			Consumer<Integer[]> consumer = (t) -> {insertionSort.sort(t,0,t.length);};
			Benchmark_Timer<Integer[]> bench = new	Benchmark_Timer<Integer[]>("result",consumer);
			double time =bench.runFromSupplier(supplier, 1000);
			return time;
	}

	private static Integer[] arr(int n, int type) {
		Integer[] arr1=new Integer[n];
		
		if(type==1)
		{
			for(int i=0;i<n;i++)
			{
				arr1[i]=i;
			}
		}else if(type==2)
		{
			for(int i=0;i<n;i++)
			{
				arr1[i]=n-i;
			}
		}else if(type==3)
		{
			for(int i=0;i<n;i++)
			{
				arr1[i]=(int)Math.random()*n;
			}
		}
		else
		{
			for(int i=0;i<n;i++)
			{
				if(i<n/2) arr1[i]=(int)Math.random()*n;
				else arr1[i]=i;
			
			}
		}	
		return arr1;
	} 

	public static void main(String[] args) {
		int[] n = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,16000,32000,64000};
		ArrayList<Double> meanTimeList = new ArrayList<Double>();
		for (int i = 1; i < 5; i++) {
			System.out.println("type: "+i);
			for (int j : n) {
				double meanT=InsertionSortResult.ddoit(j, i);
				meanTimeList.add(meanT);
			}
			for (double k : meanTimeList) {
				System.out.println(k);
			}
			meanTimeList.clear();
		}
	}
}

