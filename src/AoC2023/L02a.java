package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class L02a {
	private static List<String> game;

	public static void run(String ext) throws IOException {
		game = Files.readAllLines(Paths.get("./src/AoC2023/L02input" + ext + ".txt"));
		int sum = 0;

		for (int a = 0; a < game.size(); a++) {
			if (check(game.get(a))) {
				sum += (a+1);
			}
		}
		System.out.println("Total score: " + sum);
	}

	static boolean check(String in) {
		String[] s = in.split(" ");

		for (int i = 0; i < s.length; i++) {
			if (s[i].startsWith("red") && Integer.parseInt(s[i - 1]) > 12) {
				return false;
			}
			if (s[i].startsWith("green") && Integer.parseInt(s[i - 1]) > 13) {
				return false;
			}
			if (s[i].startsWith("blue") && Integer.parseInt(s[i - 1]) > 14) {
				return false;
			}
		}

		return true;
	}

}
