package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class L03b {
	private static List<String> r;

	public static void run(String ext) throws IOException {
		r = Files.readAllLines(Paths.get("./src/AoC2022/L03input" + ext + ".txt"));
		int sum = 0;

		for (int i = 0; i < r.size(); i += 3) {
			sum += getCommonItemNumber(r.get(i), r.get(i + 1), r.get(i + 2));
		}
		System.out.println("Sum: " + sum);
	}

	static int getCommonItemNumber(String in1,String in2,String in3) {
		for (String t : in1.split("")) {
			if (in2.contains(t) && in3.contains(t)) {
				return getPriority(t.charAt(0));
			}
		}
		return 1337;
	}

	static int getPriority(Character in) {
		return Character.isLowerCase(in) ? in - 'a' + 1 : in - 'A' + 27;
	}
}
