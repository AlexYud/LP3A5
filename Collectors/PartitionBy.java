package Collectors;

import static java.util.Arrays.asList;

import java.util.stream.Collectors;

public class PartitionBy {

	public static void main(String[] args) {
		Person sara = new Person("Sara", 4, "Norwegian");
	    Person viktor = new Person("Viktor", 40, "Serbian");
	    Person eva = new Person("Eva", 42, "Norwegian");
	    java.util.List<Person> collection = asList(sara, eva, viktor);
		System.out.println(collection.stream().collect(Collectors.partitioningBy(p -> p.getAge() >= 18)));
	}

}
