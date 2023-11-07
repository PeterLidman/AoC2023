package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class L03a {
	private static List<String> r;

	public static void run(String ext) throws IOException {
		r = Files.readAllLines(Paths.get("./src/AoC2022/L03input" + ext + ".txt"));
		int sum = 0;

		for (String a : r) {
			sum += getCommonItemNumber(a);
		}
		System.out.println("Sum: " + sum);
	}

	static int getCommonItemNumber(String in) {
		String a = in.substring(0, in.length() / 2);
		String b = in.substring(in.length() / 2);
		for (String t : a.split("")) {
			if (b.contains(t)) {
				return getPriority(t.charAt(0));
			}
		}
		return 1337;
	}

	static int getPriority(Character in) {
		return Character.isLowerCase(in) ? in - 'a' + 1 : in - 'A' + 27;
	}
}