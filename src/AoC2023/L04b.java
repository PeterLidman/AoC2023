package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class L04b {
	private static List<String> input;

	public static void run(String ext) throws IOException {
		input = Files.readAllLines(Paths.get("./src/AoC2023/L04input" + ext + ".txt"));

		int sum = 0;
		Integer[] cards = new Integer[input.size()];
		for (int i = 0; i < input.size(); i++) {
			cards[i] = 1;
		}
		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < cardPoints(input.get(i)); j++) {
				cards[i + j + 1] += cards[i];
			}
		}
		for (Integer s : cards) {
			sum += s;
		}
		System.out.println("Total " + sum);
	}

	private static int cardPoints(String in) {
		String[] split = in.split("\\|");
		String[] first = split[0].split("\s+");
		String[] second = split[1].split("\s+");

		List<Integer> winning = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();

		for (int i = 2; i < first.length; i++) {
			winning.add(Integer.valueOf(first[i]));
		}
		for (int i = 1; i < second.length; i++) {
			numbers.add(Integer.valueOf(second[i]));
		}

		int correct = 0;
		for (Integer a : winning) {
			if (numbers.contains(a)) {
				correct++;
			}
		}
		return correct;
	}
}
