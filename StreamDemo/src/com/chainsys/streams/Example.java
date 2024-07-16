package com.chainsys.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;

public class Example {

//	public static void main(String[] args) {
//		List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "custardApple",
//				"avacado");
//
//		List<String> filteredFruits = fruits.stream().filter(fruit -> fruit.startsWith("a")).map(String::toUpperCase)
//				.collect(Collectors.toList());
//
//		System.out.println("Filtered fruits starting with 'a':");
//		filteredFruits.forEach(System.out::println);
//
//		String fruitStartingWithC = fruits.stream().filter(fruit -> fruit.startsWith("c")).findFirst()
//				.orElse("No fruit found");
//
//		System.out.println("\nFirst fruit starting with 'c':");
//		System.out.println(fruitStartingWithC);
//	}

//	public static void main(String[] args) {
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//		List<Integer> doubledNumbers = numbers.stream().map(number -> number * 2).collect(Collectors.toList());
//
//		System.out.println("Original numbers: " + numbers);
//		System.out.println("Doubled numbers: " + doubledNumbers);
//	}

//	public static void main(String[] args) {
//		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
//
//		long count = words.stream().filter(word -> word.length() > 5).count();
//
//		System.out.println("Words longer than 5 characters: " + count);
//	}

//	public static void main(String[] args) {
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//		int sum = numbers.stream().reduce(0, (acc, number) -> acc + number);
//		System.out.println("Sum of numbers: " + sum);
//	}

//	public static void main(String[] args) {
//		List<String> words = Arrays.asList("banana", "apple", "date", "cherry", "elderberry");
//		List<String> sortedWords = words.stream().sorted().collect(Collectors.toList());
//
//		System.out.println("Sorted words: " + sortedWords);
//	}

//	public static void main(String[] args) {
//		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "apple");
//
//		Map<Character, Long> charCountMap = words.stream()
//				.collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));
//
//		System.out.println("Character count map: " + charCountMap);
//	}

//	public static void main(String[] args) {
//		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
//
//		List<String> longWords = words.stream().filter(word -> word.length() > 5).collect(Collectors.toList());
//
//		System.out.println("Long words (>5 characters): " + longWords);
//	}

//	public static void main(String[] args) {
//		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
//		List<String> uppercaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
//
//		System.out.println("Uppercase words: " + uppercaseWords);
//	}

//	public static void main(String[] args) {
//		List<Integer> numbers = Arrays.asList(1, 5, 2, 7, 3);
//		Optional<Integer> maxNumber = numbers.stream().max(Integer::compareTo);
//
//		maxNumber.ifPresent(max -> System.out.println("Maximum number: " + max));
//	}

//	public static void main(String[] args) {
//		List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
//		String concatenatedString = words.stream().reduce("", (acc, word) -> acc + word);
//
//		System.out.println("Concatenated string: " + concatenatedString);
//	}

	public static void main(String[] args) {
		List<List<Integer>> nestedNumbers = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5),
				Arrays.asList(6, 7, 8, 9));

		List<Integer> flattenedList = nestedNumbers.stream().flatMap(List::stream).collect(Collectors.toList());

		System.out.println("Flattened list: " + flattenedList);
	}

}
