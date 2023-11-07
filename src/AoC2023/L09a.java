package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L09a {
	private static List<String> moves;
	private static int hx;
	private static int hy;
	private static int tx;
	private static int ty;

	// too low 6351
	public static void run(String ext) throws IOException {
		moves = Files.readAllLines(Paths.get("./src/AoC2022/L09input" + ext + ".txt"));
		hx = 0;
		hy = 0;
		tx = 0;
		ty = 0;
		Map<String, Integer> v = new HashMap<>();

		v.put(String.valueOf(tx) + "," + String.valueOf(ty), 1);
		for (String a : moves) {
			String[] split = a.split(" ");
			for (int i = 0; i < Integer.valueOf(split[1]); i++) {
				switch (split[0]) {
				case "U" -> hy--;
				case "D" -> hy++;
				case "L" -> hx--;
				case "R" -> hx++;
				}
				if (Math.abs(hx - tx) > 1 || Math.abs(hy - ty) > 1) { // tail must move
					if (hx == tx) {
						yMove();
					} else if (hy == ty) {
						xMove();
					} else { // diag move needed
						yMove();
						xMove();
					}
					v.put(String.valueOf(tx) + "," + String.valueOf(ty), 1);
				}
			}
		}
		System.out.println("Visited positions: " + v.size());
	}

	private static void xMove() {
		if (hx > tx) {
			tx++;
		} else {
			tx--;
		}
	}

	private static void yMove() {
		if (hy > ty) {
			ty++;
		} else {
			ty--;
		}
	}

}
