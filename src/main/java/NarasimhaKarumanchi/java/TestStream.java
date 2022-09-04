package main.java.NarasimhaKarumanchi.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Reflection", "Sollection", "Yam");
		List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
		
		for(String s : result) {
			System.out.println(s);
		}
	}
}