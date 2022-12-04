package AoC2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class L04b {
	private static List<String> input;

	public static void run(String ext) throws IOException {
		input = Files.readAllLines(Paths.get("./src/AoC2022/L04input" + ext + ".txt"));

		int sum = 0;
		for (String s : input) {
			sum += overlaps(s);
		}
		System.out.println("Total " + sum);
	}

	private static int overlaps(String in) {
		String[] split = in.split(",");
		String[] first = split[0].split("-");
		String[] second = split[1].split("-");

		int a = Integer.valueOf(first[0]);
		int b = Integer.valueOf(first[1]);
		int c = Integer.valueOf(second[0]);
		int d = Integer.valueOf(second[1]);

		if (b - a >= d - c) {
			if ((c >= a && c <= b) || (d >= a && d <= b)) {
				return 1;
			}
		} else {
			if ((a >= c && a <= d) || (b >= c && b <= d)) {
				return 1;
			}
		}
		return 0;
	}
}
