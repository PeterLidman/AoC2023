package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class L03b {
	private static List<String> gear;
	private static Map<Entry<Integer, Integer>, Integer> gnum;
	private static Map<Entry<Integer, Integer>, Character> gsym;
	private static Map<Entry<Integer, Integer>, Entry<Integer, Integer>> gcon;

	public static void run(String ext) throws IOException {
		gear = Files.readAllLines(Paths.get("./src/AoC2023/L03input" + ext + ".txt"));
		int sum = 0;
		gnum = new HashMap<>();
		gsym = new HashMap<>();
		gcon = new HashMap<>();

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
					gnum.put(Map.entry(x, y), Integer.valueOf(n));
				} else if (c == '*') {
					gsym.put(Map.entry(x, y), c);
				}
			}
		}
		for (Entry<Entry<Integer, Integer>, Integer> n : gnum.entrySet()) {
			isSymbolClose(n.getKey(), n);
		}
		for (Entry<Entry<Integer, Integer>, Entry<Integer, Integer>> out : gcon.entrySet()) {
			for (Entry<Entry<Integer, Integer>, Entry<Integer, Integer>> in : gcon.entrySet()) {
				if (out.getValue().equals(in.getValue()) && !out.getKey().equals(in.getKey())
						&& ((out.getKey().getKey() * 140 + out.getKey().getValue()) > (in.getKey().getKey() * 140
								+ in.getKey().getValue()))) {
					sum += gnum.get(out.getKey()) * gnum.get(in.getKey());
				}
			}
		}
		System.out.println("Sum: " + sum);
	}

	private static boolean isSymbolClose(Entry<Integer, Integer> key, Entry<Entry<Integer, Integer>, Integer> n) {
		int length = String.valueOf(n.getValue()).length();
		int sx = key.getKey() - length;
		int sy = key.getValue() - 1;
		for (int x = sx; x < (sx + length + 2); x++) {
			for (int y = sy; y < (sy + 3); y++) {
				if (gsym.get(Map.entry(x, y)) != null) {
					gcon.put(n.getKey(), Map.entry(x, y));
					return true;
				}
			}
		}
		return false;
	}

}
