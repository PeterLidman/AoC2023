package AoC2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class L08a {
	private static List<String> trees;

	public static void run(String ext) throws IOException {
		trees = Files.readAllLines(Paths.get("./src/AoC2022/L08input" + ext + ".txt"));

		int visible = trees.size() * 4 - 4;
		for (int i = 1; i < trees.size() - 1; i++) {
			for (int j = 1; j < trees.size() - 1; j++) {
				visible += viewable(i, j);
			}
		}
		System.out.println("Count visible trees: " + visible);
	}

	private static int viewable(int i, int j) {
		int height = Integer.valueOf(trees.get(i).substring(j, j + 1));
		int shadowed = 0;

		for (int x = 0; x < j; x++) {
			if (height <= Integer.valueOf(trees.get(i).substring(x, x + 1))) {
				shadowed++;
				break;
			}
		}
		for (int x = trees.size() - 1; x > j; x--) {
			if (height <= Integer.valueOf(trees.get(i).substring(x, x + 1))) {
				shadowed++;
				break;
			}
		}
		for (int y = 0; y < i; y++) {
			if (height <= Integer.valueOf(trees.get(y).substring(j, j + 1))) {
				shadowed++;
				break;
			}
		}
		for (int y = trees.size() - 1; y > i; y--) {
			if (height <= Integer.valueOf(trees.get(y).substring(j, j + 1))) {
				shadowed++;
				break;
			}
		}
		return shadowed == 4 ? 0 : 1;
	}
}
