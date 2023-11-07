package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L15a {
	private static List<String> input;
	private static List<sensor> sensors = new ArrayList<>();;

	record sensor(int x, int y, int md) {
	}

	public static void run(String ext) throws IOException {
		input = Files.readAllLines(Paths.get("./src/AoC2022/L15input" + ext + ".txt"));
		Pattern integerPattern = Pattern.compile("-?\\d+");
		sensors.clear();
		int startX = 0, antal = 0, startY;
		if (ext.equals("0")) {
			startY = 2_000_000;
		} else {
			startY = 10;
		}

		for (String a : input) {
			Matcher matcher = integerPattern.matcher(a);
			matcher.find();
			int sx = Integer.valueOf(matcher.group());
			matcher.find();
			int sy = Integer.valueOf(matcher.group());
			matcher.find();
			int bx = Integer.valueOf(matcher.group());
			matcher.find();
			int by = Integer.valueOf(matcher.group());
			antal++;
			startX += sx;
			sensors.add(new sensor(sx, sy, Math.abs(sx - bx) + Math.abs(sy - by)));
		}
		startX = startX / antal;
		int endX = startX;
		while (isCovered(endX, startY)) {
			endX++;
		}
		while (isCovered(startX, startY)) {
			startX--;
		}
		System.out.println("Positions: " + (endX - startX - 2));
	}

	static boolean isCovered(int x, int y) {
		boolean covered = false;
		for (sensor a : sensors) {
			if (Math.abs(a.x - x) + Math.abs(a.y - y) <= a.md) {
				covered = true;
				break;
			}
		}
		return covered;
	}
}
