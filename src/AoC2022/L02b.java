package AoC2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class L02b {
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
			case "A X" -> 3 + 0;
			case "A Y" -> 1 + 3;
			case "A Z" -> 2 + 6;
			case "B X" -> 1 + 0;
			case "B Y" -> 2 + 3;
			case "B Z" -> 3 + 6;
			case "C X" -> 2 + 0;
			case "C Y" -> 3 + 3;
			case "C Z" -> 1 + 6;
			default -> throw new IllegalArgumentException("Unexpected value: " + strat.get(a));
			};
//			switch (strat.get(a)) {
//			case "A X":// rock lose
//				sum += 3 + 0 ;
//				break;
//			case "A Y":// rock draw
//				sum += 1 + 3;
//				break;
//			case "A Z":// rock win
//				sum += 2 + 6;
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
//				sum += 2 + 0;
//				break;
//			case "C Y":
//				sum += 3 + 3;
//				break;
//			case "C Z":
//				sum += 1 + 6;
//				break;
//			}
		}
		System.out.println("Total score: " + sum);
	}
}
