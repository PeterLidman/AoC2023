package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L15b {
	private static List<String> input;
	private static List<sensor> sensors = new ArrayList<>();
	private static int startY;
	private static boolean found;

	record sensor(int x, int y, int md) {
	}

	public static void run(String ext) throws IOException {
		input = Files.readAllLines(Paths.get("./src/AoC2022/L15input" + ext + ".txt"));
		Pattern integerPattern = Pattern.compile("-?\\d+");
		sensors.clear();
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
			sensors.add(new sensor(sx, sy, Math.abs(sx - bx) + Math.abs(sy - by)));
		}

		found = false;
		for (int i = 0; i < sensors.size() && !found; i++) {
			sensor sb1 = sensors.get(i);
			for (int k = 0; k < sb1.md(); k++) {
				isCovered(sb1.x + k, sb1.y + sb1.md() + 1 - k);
			}
			for (int k = 0; k < sb1.md(); k++) {
				isCovered(sb1.x + k, sb1.y - sb1.md() - 1 + k);
			}
			for (int k = 0; k < sb1.md(); k++) {
				isCovered(sb1.x - k, sb1.y + sb1.md() + 1 - k);
			}
			for (int k = 0; k < sb1.md(); k++) {
				isCovered(sb1.x - k, sb1.y - sb1.md() - 1 + k);
			}
		}
	}

	static boolean isCovered(int x, int y) {
		if (x > startY * 2 || y > startY * 2 || x < 0 || y < 0) {
			return true;
		}
		boolean covered = false;
		for (sensor a : sensors) {
			if (Math.abs(a.x - x) + Math.abs(a.y - y) <= a.md) {
				covered = true;
				break;
			}
		}
		if (!covered) {
			System.out.println("x=" + x + " y=" + y + " freq=" + ((long) x * 4_000_000 + (long) y));
			found = true;
		}
		return covered;
	}

}
