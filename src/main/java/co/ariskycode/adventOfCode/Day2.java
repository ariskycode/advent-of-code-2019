package co.ariskycode.adventOfCode;

/**
 * <h2>AOC Day 2: IntCode program</h2> Solve for value at pos 0
 * 
 * @see <a href="https://adventofcode.com/2019/day/2">AOC Day 2</a>
 * 
 * @author <a href="https://github.com/ariskycode">ariskycode</a>
 *
 */
public class Day2 {

	public static void main(String[] args) {
		System.out.print("IntCode program 1 output : ");
		System.out.println(partOne());
		System.out.print("IntCode program 2 output : ");
		System.out.println(partTwo());
	}

	private static int partOne() {
		int[] intCode = getInputArray();
		intCode = runIntCode(intCode);
		return intCode[0];
	}

	public static int[] runIntCode(int[] intCode) {
		for (int i = 0; i < intCode.length; i += 4) {
			if (intCode[i] == 99)
				break;
			if (intCode[i] == 1)
				add(intCode, i);
			if (intCode[i] == 2)
				multiply(intCode, i);
		}
		return intCode;
	}

	private static int partTwo() {
		int noun, verb = 0;
		int[] intCode = {};
		//TODO: optimize, should not brute force
		for (noun = 0; noun < 50; noun ++) {
			for (verb = 0; verb < 50; verb ++) {
				intCode = getInputArray();
				intCode[1] = noun;
				intCode[2] = verb;
				intCode = runIntCode(intCode);
				if (intCode[0] == 19690720) break;
			}
			if (intCode[0] == 19690720) break;
		}
		return 100 * noun + verb;
	}

	private static void add(int[] intCode, int i) {
		intCode[intCode[i+3]] = intCode[intCode[i+1]] + intCode[intCode[i+2]];
	}

	private static void multiply(int[] intCode, int i) {
		intCode[intCode[i+3]] = intCode[intCode[i+1]] * intCode[intCode[i+2]];

	}

	public static int[] getInputArray() {
		int[] array = /*{ 1, 9, 10, 3,				//Test IntCode
						2, 3, 11, 0,
						99,
						30, 40, 50};*/
					  { 1, 12, 2, 3,
						1, 1, 2, 3,
						1, 3, 4, 3,
						1, 5, 0, 3,
						2, 10, 1, 19,
						1, 6, 19, 23,
						2, 23, 6, 27,
						1, 5, 27, 31,
						1, 31, 9, 35,
						2, 10, 35, 39,
						1, 5, 39, 43,
						2, 43, 10, 47,
						1, 47, 6, 51,
						2, 51, 6, 55,
						2, 55, 13, 59,
						2, 6, 59, 63,
						1, 63, 5, 67,
						1, 6, 67, 71,
						2, 71, 9, 75,
						1, 6, 75, 79,
						2, 13, 79, 83,
						1, 9, 83, 87,
						1, 87, 13, 91,
						2, 91, 10, 95,
						1, 6, 95, 99,
						1, 99, 13, 103,
						1, 13, 103, 107,
						2, 107, 10, 111,
						1, 9, 111, 115,
						1, 115, 10, 119,
						1, 5, 119, 123,
						1, 6, 123, 127,
						1, 10, 127, 131,
						1, 2, 131, 135,
						1, 135, 10, 0,
						99,
						2, 14, 0, 0 };
		return array;
	}

}
