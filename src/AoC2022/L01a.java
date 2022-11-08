package AoC2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class L01a {
	private static List<Integer> depth;

	public static void run(String ext) {
		try {
			depth = Files.readAllLines(Paths.get("./src/AoC2022/L01input" + ext + ".txt")).stream()
					.map(Integer::valueOf).collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("fel vid filimport: " + e);
		}

		int currentDepth = depth.get(0);
		int noIncreased = 0;
		int newDepth;
		for (int a = 1; a < depth.size(); a++) {
			newDepth = depth.get(a);

			if (currentDepth < newDepth) {
				noIncreased++;
			}
			currentDepth = newDepth;

		}
		System.out.println("Depth increased " + noIncreased + " times");
	}
}
