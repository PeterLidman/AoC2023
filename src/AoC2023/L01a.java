package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class L01a {
	private static List<String> cal;

	public static void run(String ext) {
		try {
			cal = Files.readAllLines(Paths.get("./src/AoC2023/L01input" + ext + ".txt")).stream()
					.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("fel vid filimport: " + e);
		}

		int sum = 0, max = 0;
		
		for (int a = 0; a < cal.size(); a++) {
			if (cal.get(a).equals("")) {
				max = Math.max(max, sum);
				sum = 0;
			} else {
				sum += Integer.valueOf(cal.get(a));
			}
		}
		max = Math.max(max, sum);
		System.out.println("Max cal= " + max);
	}
}
