package AoC2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class L08b {
	private static List<String> trees;

	public static void run(String ext) throws IOException {
		trees = Files.readAllLines(Paths.get("./src/AoC2022/L08input" + ext + ".txt"));

		int scenic = 0;
		for (int i = 1; i < trees.size() - 1; i++) {
			for (int j = 1; j < trees.size() - 1; j++) {
				scenic = Math.max(scenic, scenicValue(i, j));
			}
		}
		System.out.println("Scenic value: " + scenic);
		// 300 to low
		// 432 to low
	}

	private static int scenicValue(int i, int j) {
		int h = Integer.valueOf(trees.get(i).substring(j, j + 1));
		int ss = 1;

		List<Integer> c = new ArrayList<>();
		for (int x = j - 1; x >= 0; x--) {// vänster
			int th = Integer.valueOf(trees.get(i).substring(x, x + 1));
			c.add(th);
		}
		ss *= viewDist(h, c);

		c.clear();
		for (int x = j + 1; x < trees.size(); x++) {// höger
			int th = Integer.valueOf(trees.get(i).substring(x, x + 1));
			c.add(th);
		}
		ss *= viewDist(h, c);

		c.clear();
		for (int y = i - 1; y >= 0; y--) {// upp
			int th = Integer.valueOf(trees.get(y).substring(j, j + 1));
			c.add(th);
		}
		ss *= viewDist(h, c);

		c.clear();
		for (int y = i + 1; y < trees.size(); y++) {// ner
			int th = Integer.valueOf(trees.get(y).substring(j, j + 1));
			c.add(th);
		}
		ss *= viewDist(h, c);

		return ss;
	}

	private static int viewDist(int h, List<Integer> c) {
		int v = 1;
		if (c.get(0) < h) {
			v = 0;
			for (Integer a : c) {
				v++;
				if (a >= h) {
					break;
				}
			}
		}
		return v;
	}
}
