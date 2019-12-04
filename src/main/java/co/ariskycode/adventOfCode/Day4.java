package co.ariskycode.adventOfCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <h2>AOC Day 4: Password</h2> Find all 6 digit numbers that are ever
 * increasing in the given range
 * 
 * @see <a href="https://adventofcode.com/2019/day/4">AOC Day 4</a>
 * 
 * @author <a href="https://github.com/ariskycode">ariskycode</a>
 *
 */
public class Day4 {

	public static void main(String[] args) {
		System.out.print("Count of ever increasing 6 digit numbers between 382345-843167 : ");
		System.out.println(partOne());
		System.out.print("Count of ever increasing 6 digit numbers with a pair of digits between 382345-843167 : ");
		System.out.println(partTwo());
	}

	private static int partOne() {
		int count = 0;
		for (int password = 382345; password < 843167; password++) {
			int[] digits = String.valueOf(password).chars().map(Character::getNumericValue).toArray();
			if (checkIfNumberisEverIncreasing(digits)) {
				if (checkIfNumbercontainsDuplicates(digits)) {
					count++;
				}
			}
		}
		return count;
	}

	private static int partTwo() {
		int count = 0;
		for (int password = 382345; password < 843167; password++) {
			int[] digits = String.valueOf(password).chars().map(Character::getNumericValue).toArray();
			if (checkIfNumberisEverIncreasing(digits)) {
				if (checkIfNumbercontainsDuplicates(digits)) {
					if (checkIfNumbercontainsaPairofAnyDigit(digits)) {
						count++;
					}
				}
			}
		}
		return count;
	}

	private static boolean checkIfNumberisEverIncreasing(int[] digits) {
		for (int i = 0; i < digits.length - 1; i++) {
			if (digits[i] > digits[i + 1])
				return false;
		}
		return true;
	}

	private static boolean checkIfNumbercontainsDuplicates(int[] digits) {
		Set<Integer> digitSet = new HashSet<>();
		for (int digit : digits) {
			if (!digitSet.add(digit))
				return true;
		}
		return false;
	}

	private static boolean checkIfNumbercontainsaPairofAnyDigit(int[] digits) {
		List<Integer> digitsCollection = IntStream.of(digits).boxed().collect(Collectors.toList());
		for (Integer digit : digits) {
			if (Collections.frequency(digitsCollection, digit) == 2)
				return true;
		}
		return false;
	}
}
