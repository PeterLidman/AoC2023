package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L14a {
	private static List<String> rr;

	public static void run(String ext) throws IOException {
		rr = Files.readAllLines(Paths.get("./src/AoC2022/L14input" + ext + ".txt"));

		Map<Map.Entry<Integer, Integer>, Character> cave = new HashMap<>();

		int startX = 0, startY = 0, stopX = 0, stopY = 0;
		int maxX = 500, minX = 500, maxY = 0;
		for (String a : rr) {
			String aa[] = a.split(" -> ");
			String aaa[] = aa[0].split(",");
			startX = Integer.valueOf(aaa[0]);
			startY = Integer.valueOf(aaa[1]);
			maxX = Math.max(maxX, startX);
			maxY = Math.max(maxY, startY);
			for (int i = 1; i < aa.length; i++) {
				aaa = aa[i].split(",");
				stopX = Integer.valueOf(aaa[0]);
				stopY = Integer.valueOf(aaa[1]);
				if (startX == stopX) {
					if (startY > stopY) {
						for (int j = stopY; j <= startY; j++) {
							cave.put(Map.entry(startX, j), '#');
						}
					} else {
						for (int j = startY; j <= stopY; j++) {
							cave.put(Map.entry(startX, j), '#');
						}
					}
				} else {
					if (startX > stopX) {
						for (int j = stopX; j <= startX; j++) {
							cave.put(Map.entry(j, startY), '#');
						}
					} else {
						for (int j = startX; j <= stopX; j++) {
							cave.put(Map.entry(j, startY), '#');
						}
					}
				}
				maxX = Math.max(maxX, stopX);
				minX = Math.min(minX, stopX);
				maxY = Math.max(maxY, stopY);
				startX = stopX;
				startY = stopY;
			}
		}

		int sandAtX = 500, sandAtY = 0, sandAtRest = 0;
		while (true) {
			// free falling
			while (cave.get(Map.entry(sandAtX, sandAtY + 1)) == null && sandAtY < maxY) {
				sandAtY++;
			}
			if (sandAtY >= maxY) { // drop over the edge to the abyss
				break;
			}
			// hit something
			if (cave.get(Map.entry(sandAtX - 1, sandAtY + 1)) == null) { // drop left
				sandAtY++;
				sandAtX--;
			} else if (cave.get(Map.entry(sandAtX + 1, sandAtY + 1)) == null) { // drop right
				sandAtY++;
				sandAtX++;
			} else { // come to rest
				cave.put(Map.entry(sandAtX, sandAtY), 'o');
				sandAtX = 500; // new sand enters
				sandAtY = 0;
				sandAtRest++;
			}
		}

		for (int y = 0; y <= maxY; y++) {
			for (int x = minX; x <= maxX; x++) {
				Character c = cave.get(Map.entry(x, y));
				if (c == null) {
					System.out.print(".");
				} else {
					System.out.print(c);
				}
			}
			System.out.println();
		}
		System.out.println("Resting sand units: " + sandAtRest);
	}
}
