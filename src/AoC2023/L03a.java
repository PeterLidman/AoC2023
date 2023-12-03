package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class L03a {
	private static List<String> gear;
	private static Map<Entry<Integer, Integer>, Integer> gn;
	private static Map<Entry<Integer, Integer>, Character> gs;

	public static void run(String ext) throws IOException {
		gear = Files.readAllLines(Paths.get("./src/AoC2023/L03input" + ext + ".txt"));
		int sum = 0;
		gn = new HashMap<>();
		gs = new HashMap<>();

		for (int y = 0; y < gear.size(); y++) {
			for (int x = 0; x < gear.get(y).length(); x++) {
				char c = gear.get(y).charAt(x);
				if (Character.isDigit(c)) {
					String n = "";
					while (x < gear.get(y).length() && Character.isDigit(gear.get(y).charAt(x))) {
						n += gear.get(y).charAt(x);
						x++;
					}
					x--;
					gn.put(Map.entry(x, y), Integer.valueOf(n));
				} else if (c != '.') {
					gs.put(Map.entry(x, y), c);
				}
			}
		}
		for (Entry<Entry<Integer, Integer>, Integer> n : gn.entrySet()) {
			if (isSymbolClose(n.getKey(), String.valueOf(n.getValue()).length())) {
				sum += n.getValue();
			}
		}
		System.out.println("Sum: " + sum);
	}

	private static boolean isSymbolClose(Entry<Integer, Integer> key, int length) {
		int sx = key.getKey() - length;
		int sy = key.getValue() - 1;
		for (int x = sx; x < (sx + length + 2); x++) {
			for (int y = sy; y < (sy + 3); y++) {
				if (gs.get(Map.entry(x, y)) != null) {
					return true;
				}
			}
		}
		return false;
	}

}
