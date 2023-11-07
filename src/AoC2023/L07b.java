package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L07b {
	private static List<String> _folders;
	private static Map<String, List<String>> d;

	public static void run(String ext) throws IOException {
		_folders = Files.readAllLines(Paths.get("./src/AoC2022/L07input" + ext + ".txt"));

		d = new HashMap<>();
		List<String> currentDir = new ArrayList<>();

		for (int i = 0; i < _folders.size(); i++) {
			String row = _folders.get(i);
			if (row.contains("$ cd ")) {
				if (_folders.get(i).equals("$ cd ..")) {
					currentDir.remove(currentDir.size() - 1);
				} else {
					currentDir.add(row.substring(5));
					d.put(currentDir.toString(), new ArrayList<>());
				}
			} else if (row.equals("$ ls")) {
			} else if (row.contains("dir ")) {
				String dir = currentDir.toString();
				List<String> list = d.get(dir);
				currentDir.add(row.substring(4));
				list.add("dir " + currentDir.toString());
				d.put(dir, list);
				currentDir.remove(currentDir.size() - 1);
			} else {
				String dir = currentDir.toString();
				List<String> list = d.get(dir);
				list.add(row);
				d.put(dir, list);
			}
		}

		long smallest = 70_000_000;
		long needAtLeast = GetSize("[/]") - 40_000_000;
		for (String a : d.keySet()) {
			long size = GetSize(a);
			if (size >= needAtLeast) {
				smallest = Math.min(smallest, size);
			}
		}
		System.out.println("Total size of smallest deleted directory= " + smallest);
	}

	private static long GetSize(String a) {
		long sum = 0;
		for (String s : d.get(a)) {
			if (s.contains("dir ")) {
				sum += GetSize(s.substring(4));
			} else {
				sum += Long.valueOf(s.split(" ")[0]);
			}
		}
		return sum;
	}
}
