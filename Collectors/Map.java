package Collectors;

import static java.util.Arrays.asList;

import java.util.stream.Collectors;

public class Map {

	public static void main(String[] args) {
		java.util.List<String> collection = asList("My", "name", "is", "John", "Doe");
		System.out.println(collection.stream().map(String::toUpperCase).collect(Collectors.toList())); 
	}

}
