package Collectors;


import static java.util.Arrays.asList;

import java.util.stream.Collectors;

public class List {
	
	public static void main(String[] args) {
		java.util.List<java.util.List<String>> collection = asList(asList("Um", "Dois"), asList("Três", "Quatro", "Cinco"));
		System.out.println(collection.stream().flatMap(list -> list.stream()).collect(Collectors.toList()));
	}
	

}
