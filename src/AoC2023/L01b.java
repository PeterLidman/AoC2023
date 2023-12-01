package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class L01b {
	private static List<String> cal;

	public static void run(String ext) throws IOException {
		cal = Files.readAllLines(Paths.get("./src/AoC2023/L01input" + ext + ".txt")).stream()
				.collect(Collectors.toList());

		long sum = 0;

		for (int a = 0; a < cal.size(); a++) {
			String newString = "";
			String oldString = cal.get(a);

			for (int i = 0; i < oldString.length(); i++) {
				if (Character.isDigit(oldString.charAt(i))) {
					newString = newString + oldString.substring(i, i + 1);
				} else {
					if (oldString.substring(i).startsWith("one")) {
						newString = newString + "1";
					} else if (oldString.substring(i).startsWith("two")) {
						newString = newString + "2";
					} else if (oldString.substring(i).startsWith("three")) {
						newString = newString + "3";
					} else if (oldString.substring(i).startsWith("four")) {
						newString = newString + "4";
					} else if (oldString.substring(i).startsWith("five")) {
						newString = newString + "5";
					} else if (oldString.substring(i).startsWith("six")) {
						newString = newString + "6";
					} else if (oldString.substring(i).startsWith("seven")) {
						newString = newString + "7";
					} else if (oldString.substring(i).startsWith("eight")) {
						newString = newString + "8";
					} else if (oldString.substring(i).startsWith("nine")) {
						newString = newString + "9";
					}
				}
			}
			char[] ca = newString.toCharArray();
//			System.out.println(ca);

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
//			System.out.println(v);
			sum += v;
		}
		System.out.println("Sum cal= " + sum);
	}
}
