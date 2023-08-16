package main.java.NarasimhaKarumanchi.java;

import java.util.EmptyStackException;

import main.java.NarasimhaKarumanchi.java._1_LinkedList.LinkedList;
import main.java.NarasimhaKarumanchi.java._1_LinkedList.ListNode;
import main.java.NarasimhaKarumanchi.java._2_Stacks.DynamicStackService;
import main.java.NarasimhaKarumanchi.java._2_Stacks.FixedArrayStack;
import main.java.NarasimhaKarumanchi.java._2_Stacks.FixedStackService;

public class Test<T> {
	
	// method which calculates square root of a number up to given precision
	
	public double sqrt(int num, double l) {
		

        // Assuming the sqrt of n as n only
        double x = num;
     
        // The closest guess will be stored in the root
        double root;
     
        // To count the number of iterations
        int count = 0;
     
        while (true)
        {
            count++;
     
            // Calculate more closed x   (Newton Raphson Method)
            root = 0.5 * (x + (num / x));
     
            // Check for closeness
            if (Math.abs(root - x) < l)
                break;
     
            // Update root
            x = root;
        }
     
        return root;
    }


	
	public static void main(String[] args) {
		
		Test<Integer> t = new Test<>();
		int inp = 3;
		
		double l = 0.000000000001;
		
		double sqrt = t.sqrt(inp, l);

		System.out.println("Square root of " + inp + " is " + sqrt);

	}

}
