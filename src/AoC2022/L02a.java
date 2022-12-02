package AoC2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class L02a {
	private static List<String> strat;

	public static void run(String ext) {
		try {
			strat = Files.readAllLines(Paths.get("./src/AoC2022/L02input" + ext + ".txt")).stream()
					.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Fel vid filimport: " + e);
		}

		int sum = 0;

		for (int a = 0; a < strat.size(); a++) {
			sum += switch (strat.get(a)) {
			case "A X" -> 1 + 3;
			case "A Y" -> 2 + 6;
			case "A Z" -> 3 + 0;
			case "B X" -> 1 + 0;
			case "B Y" -> 2 + 3;
			case "B Z" -> 3 + 6;
			case "C X" -> 1 + 6;
			case "C Y" -> 2 + 0;
			case "C Z" -> 3 + 3;
			default -> throw new IllegalArgumentException("Unexpected value: " + strat.get(a));
			};

//			switch (strat.get(a)) {
//			case "A X":// rock rock
//				sum += 1 + 3;
//				break;
//			case "A Y":// rock paper
//				sum += 2 + 6;
//				break;
//			case "A Z":// rock scissors
//				sum += 3 + 0;
//				break;
//			case "B X":// paper
//				sum += 1 + 0;
//				break;
//			case "B Y":
//				sum += 2 + 3;
//				break;
//			case "B Z":
//				sum += 3 + 6;
//				break;
//			case "C X":// scissors
//				sum += 1 + 6;
//				break;
//			case "C Y":
//				sum += 2 + 0;
//				break;
//			case "C Z":
//				sum += 3 + 3;
//				break;
//			}
		}
		System.out.println("Total score: " + sum);
	}
}
