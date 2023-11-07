package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class L02b {
	private static List<String> strat;

	public static void run(String ext) throws IOException {
		strat = Files.readAllLines(Paths.get("./src/AoC2022/L02input" + ext + ".txt"));
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
		}
		System.out.println("Total score: " + sum);
	}
}
