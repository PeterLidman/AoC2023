package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class L02b {
	private static List<String> game;

	public static void run(String ext) throws IOException {
		game = Files.readAllLines(Paths.get("./src/AoC2023/L02input" + ext + ".txt"));
		int sum = 0;

		for (int a = 0; a < game.size(); a++) {
			sum += power(game.get(a));
		}
		System.out.println("Total score: " + sum);
	}

	static int power(String in) {
		String[] s = in.split(" ");
		int r = 1, g = 1, b = 1;

		for (int i = 0; i < s.length; i++) {
			if (s[i].startsWith("red")) {
				r = Math.max(r, Integer.parseInt(s[i - 1]));
			}
			if (s[i].startsWith("green")) {
				g = Math.max(g, Integer.parseInt(s[i - 1]));
			}
			if (s[i].startsWith("blue")) {
				b = Math.max(b, Integer.parseInt(s[i - 1]));
			}
		}

		return r * g * b;
	}

}
