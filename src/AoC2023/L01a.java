package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class L01a {
	private static List<String> cal;

	public static void run(String ext) throws IOException {
		cal = Files.readAllLines(Paths.get("./src/AoC2023/L01input" + ext + ".txt")).stream()
				.collect(Collectors.toList());

		long sum = 0;

		for (int a = 0; a < cal.size(); a++) {
			char[] ca = cal.get(a).toCharArray();
			int v = 0;
			for (int b = 0; b < ca.length; b++) {
				if (Character.isDigit(ca[b])) {
					v += 10 * (ca[b] - '0');
					break;
				}
			}
			for (int b = ca.length - 1; b >= 0; b--) {
				if (Character.isDigit(ca[b])) {
					v += ca[b] - '0';
					break;
				}
			}
			//System.out.println(v);
			sum += v;
		}
		System.out.println("Sum cal= " + sum);
	}
}
