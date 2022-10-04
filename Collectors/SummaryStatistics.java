package Collectors;

import static java.util.Arrays.asList;

import java.util.stream.Collectors;

public class SummaryStatistics {

	public static void main(String[] args) {
		Person sara = new Person("Sara", 4);
	    Person viktor = new Person("Viktor", 40);
	    Person eva = new Person("Eva", 42);
	    Person anna = new Person("Anna", 5);
	    java.util.List<Person> collection = asList(sara, eva, viktor, anna);
	    System.out.println(collection.stream().mapToInt(Person::getAge).summaryStatistics());
	}

}
