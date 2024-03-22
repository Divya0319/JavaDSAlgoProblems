package main.java.NarasimhaKarumanchi.java;

import java.util.ArrayList;

public class PrintPermutationsOfString {
	
	public void permute(String str, int idx, String curr, ArrayList<String> ans, boolean[] visited) {
		int n = str.length();
		
		if(idx == n) {
			ans.add(new String(curr));
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				permute(str, idx + 1, curr + str.charAt(i), ans, visited);
				
				visited[i] = false;
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		PrintPermutationsOfString ppos = new PrintPermutationsOfString();
		
		String s = "abc";
		
		ArrayList<String> ans = new ArrayList<>();
		
		String curr = "";
		
		boolean[] visited = new boolean[s.length()];
		
		ppos.permute(s, 0, curr, ans, visited);
		
		System.out.println(ans.toString());
	}

}
