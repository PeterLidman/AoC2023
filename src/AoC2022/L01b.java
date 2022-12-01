package AoC2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class L01b {
	private static List<String> cal;

	public static void run(String ext) {
		try {
			cal = Files.readAllLines(Paths.get("./src/AoC2022/L01input" + ext + ".txt")).stream()
					.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("fel vid filimport: " + e);
		}

		int sum = 0;
		List<Integer> sumList = new ArrayList<>();

		for (int a = 0; a < cal.size(); a++) {
			if (cal.get(a).equals("")) {
				sumList.add(sum);
				sum = 0;
			} else {
				sum += Integer.valueOf(cal.get(a));
			}
		}
		sumList.add(sum);
		sumList.sort(null);
		System.out.println("3Max cal= " + (sumList.get(sumList.size()-3) + sumList.get(sumList.size()-2) + sumList.get(sumList.size()-1))	);
	}
}
