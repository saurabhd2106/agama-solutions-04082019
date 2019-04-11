package demo;

import java.util.LinkedList;
import java.util.List;

public class DemoXpathLogic {

	public static void main(String[] args) {

		List<Integer> linkedList = new LinkedList<>();

		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<10E5; i++){
			linkedList.add(i);
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time taken : " + (endTime - startTime));

	}

}
