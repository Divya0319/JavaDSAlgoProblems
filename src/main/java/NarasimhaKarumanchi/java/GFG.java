package main.java.NarasimhaKarumanchi.java;

//Java program to remove all adjacent duplicates from a
//string

public class GFG {

	static char last_removed; //will store the last char removed during recursion

	// Recursively removes adjacent duplicates from str and
	// returns new string. last_removed is a pointer to
	// last_removed character
	static String removeUtil(String str)
	{

		// If length of string is 1 or 0
		if (str.length() == 0 || str.length() == 1)
			return str;

		// Remove leftmost same characters and recur for
		// remaining string
		if (str.charAt(0) == str.charAt(1)) {
			last_removed = str.charAt(0);
			while (str.length() > 1
				&& str.charAt(0) == str.charAt(1))
				str = str.substring(1, str.length());
			str = str.substring(1, str.length());
			return removeUtil(str);
		}

		// At this point, the first character is definitely
		// different from its adjacent. Ignore first
		// character and recursively remove characters from
		// remaining string
		String rem_str
			= removeUtil(str.substring(1, str.length()));

		// Check if the first character of the rem_string
		// matches with the first character of the original
		// string
		if (rem_str.length() != 0
			&& rem_str.charAt(0) == str.charAt(0)) {
			last_removed = str.charAt(0);

			// Remove first character
			return rem_str.substring(1, rem_str.length());
		}

		// If remaining string becomes empty and last
		// removed character is same as first character of
		// original string. This is needed for a string like
		// "acbbcddc"
		if (rem_str.length() == 0
			&& last_removed == str.charAt(0))
			return rem_str;

		// If the two first characters of str and rem_str
		// don't match, append first character of str before
		// the first character of rem_str
		return (str.charAt(0) + rem_str);
	}
	
	static String removeDuplicate(String s) {
		char[] stack = new char[s.length()];
		int i = 0;
		
		for(int j = 0; j < s.length(); j++) {
			char current_char = s.charAt(j);
			
			if(i > 0 && stack[i-1] == current_char) {
				i--;
			}
			else {
				stack[i] = current_char;
				i += 1;
			}
		}
		
		return new String(stack, 0, i);
	}

	static String remove(String str)
	{
		last_removed = '\0';
		return removeUtil(str);
	}

	// Driver code
	public static void main(String args[])
	{
		String str1 = "156888011065";
		System.out.println(remove(str1));

		String str2 = "azxxxzy";
		System.out.println(remove(str2));

		String str3 = "caaabbbaac";
		System.out.println(remove(str3));

		String str4 = "gghhg";
		System.out.println(remove(str4));

		String str5 = "aaaacddddcappp";
		System.out.println(remove(str5));

		String str6 = "aaaaaaaaaa";
		System.out.println(remove(str6));

		String str7 = "qpaaaaadaaaaadprq";
		System.out.println(remove(str7));

		String str8 = "acaaabbbacdddd";
		System.out.println(remove(str8));
	}
}

//This code is contributed by Aditya Kumar (adityakumar129)

