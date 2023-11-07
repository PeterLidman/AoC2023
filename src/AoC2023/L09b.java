package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L09b {
	private static List<String> moves;
	private static int[] x = new int[10];
	private static int[] y = new int[10];

	public static void run(String ext) throws IOException {
		moves = Files.readAllLines(Paths.get("./src/AoC2022/L09input" + ext + ".txt"));
		Map<String, Integer> v = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			x[i] = 0;
			y[i] = 0;
		}
		v.put(String.valueOf(x[9]) + "," + String.valueOf(y[9]), 1);
		for (String a : moves) {
			String[] split = a.split(" ");
			for (int i = 0; i < Integer.valueOf(split[1]); i++) {
				switch (split[0]) {
				case "U" -> y[0]--;
				case "D" -> y[0]++;
				case "L" -> x[0]--;
				case "R" -> x[0]++;
				}
				for (int j = 1; j < 10; j++) {
					if (Math.abs(x[j - 1] - x[j]) > 1 || Math.abs(y[j - 1] - y[j]) > 1) {
						if (x[j - 1] == x[j]) {
							yMove(j);
						} else if (y[j - 1] == y[j]) {
							xMove(j);
						} else {
							yMove(j);
							xMove(j);
						}
					}
				}
				if (null == v.put(String.valueOf(x[9]) + "," + String.valueOf(y[9]), 1)) {
//					System.out.println("9: x= " + x[9] + " y= " + y[9]);
				}
			}
		}
		System.out.println("Visited positions: " + v.size());
	}

	private static void xMove(int o) {
		if (x[o - 1] > x[o]) {
			x[o]++;
		} else {
			x[o]--;
		}
	}

	private static void yMove(int o) {
		if (y[o - 1] > y[o]) {
			y[o]++;
		} else {
			y[o]--;
		}
	}

}
