package edu.neu.coe.info6205.sort.elementary;

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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		double a=InsertionSortResult.ddoit(300, 4);
		double b=InsertionSortResult.ddoit(600, 4);
		double c=InsertionSortResult.ddoit(1200, 4);
		double d=InsertionSortResult.ddoit(2400, 4);
		double e=InsertionSortResult.ddoit(4800, 4);
		System.out.println(a+"  "+b+"  "+c+"  "+d+"  "+e+"  ");
	}
}

