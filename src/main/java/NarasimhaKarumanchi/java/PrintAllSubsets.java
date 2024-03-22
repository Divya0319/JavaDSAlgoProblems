package main.java.NarasimhaKarumanchi.java;

import java.util.ArrayList;

public class PrintAllSubsets {
	
	public void subsets(int[] arr, int idx, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans) {
		
		if(idx == arr.length) {
			// copy all elements of current list into another list
			ans.add(new ArrayList<>(curr));
			return;
		}
		
		curr.add(arr[idx]);
		subsets(arr, idx+1, curr, ans);
		
		curr.remove(curr.size() - 1);
		subsets(arr, idx+1, curr, ans);
		
	}
	
	public static void main(String[] args) {
		PrintAllSubsets pas = new PrintAllSubsets();
		int[] inp = new int[] {3, 4, 5, 6, 7, 8};
		ArrayList<Integer> curr = new ArrayList<>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		pas.subsets(inp, 0, curr, ans);
		
		System.out.println(ans.toString());
	}

}
