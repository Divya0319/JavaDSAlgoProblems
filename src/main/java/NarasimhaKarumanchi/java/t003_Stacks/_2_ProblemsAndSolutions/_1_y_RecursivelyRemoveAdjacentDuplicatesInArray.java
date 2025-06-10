package main.java.NarasimhaKarumanchi.java.t003_Stacks._2_ProblemsAndSolutions;

import java.util.Arrays;

public class _1_y_RecursivelyRemoveAdjacentDuplicatesInArray {
	
	public int[] removeDuplicates(int[] inp, int last_removed) {
		
		/*
		 * below is base condition
		 * i.e. when array reduces to single element
		 * or blank,
		 * we simply return it
		 */
		if(inp.length == 0 || inp.length == 1) {
			return inp;
		}
		
		/*
		 * below code checks if i/p array has
		 * 1st and 2nd same no.s,
		 * if yes, it keeps track of last duplicate
		 * element removed, in 'last_removed'
		 * and removes all duplicates one-by-one
		 * (using Arrays.copyOfRange())
		 */
		
		if(inp[0] == inp[1]) {
			last_removed = inp[0];
			while(inp.length > 1 && inp[0] == inp[1]) {
				inp = Arrays.copyOfRange(inp, 1, inp.length);
			}
			
			/*  removing last occurrence of duplicate */
			inp = Arrays.copyOfRange(inp, 1, inp.length);
			
			/* and making further recursive call
			 * for removing right side of original array
			 */
			return removeDuplicates(inp, last_removed);
		}
		
		/*
		 * when first two numbers of array are different
		 * we make further recursive call, 
		 * excluding first element of array,
		 * for making array reduce eventually to single element
		 * or empty, as follows:
		 */
		
		int[] rem = removeDuplicates(Arrays.copyOfRange(inp, 1, inp.length), last_removed);
		
		/*
		 * below code checks for duplicates when 1st pass of method call is finished
		 * And after all duplicates are removed on first traversal.
		 * Here we begin 2nd traversal
		 * (making sure no duplicates are remaining in final answer).
		 */
		
		if(rem.length != 0 && rem[0] == inp[0]) {
			
			// storing currently removed duplicate no.
			last_removed = inp[0];
			
			/*
			 *  passing back resultant array
			 *  for checking remaining array on right
			 */
			return Arrays.copyOfRange(rem, 1, rem.length);
		}
		
		/* 
		 * when nothing left in original array,
		 * but last element removed was first element
		 * of input in this call,
		 */
		if(rem.length == 0 && last_removed == inp[0]) {
			// we simply return blank array
			
			return rem;
		}
		
		/* 
		 * here we create final resultant array bit by bit.
		 * We removed all different no. from beginning of array
		 * at every call. We put back those removed no.s at beginning
		 * of array again one by one,
		 * & put remaining derived array after duplicates removal, 
		 * after 1st element, one by one.
		 */
		
		int[] res = new int[rem.length + 1];
		res[0] = inp[0];
		for(int i = 0; i < rem.length; i++) {
			res[i + 1] = rem[i];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
				
		_1_y_RecursivelyRemoveAdjacentDuplicatesInArray mainClass = new _1_y_RecursivelyRemoveAdjacentDuplicatesInArray();
		
		int[] inp = new int[] {1,9,6,8,8,8,0,1,1,0,6,5};
		
		System.out.println("Given array: " + Arrays.toString(inp));
		
		int[] result = mainClass.removeDuplicates(inp, -1);
		
		System.out.println("Array after duplicate removal: " + Arrays.toString(result));
		
	}

}
