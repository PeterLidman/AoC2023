package AoC2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class L13b {
	private static List<String> signal;

	public static void run(String ext) throws IOException {
		signal = Files.readAllLines(Paths.get("./src/AoC2022/L13input" + ext + ".txt"));
		String a, b;
		int c1 = 1,c2=2;
		for (int i = 0; i < signal.size(); i += 3) {
			a = signal.get(i);
			b = signal.get(i + 1);
			if (compare(a, "[[2]]") == 1) {
				c1 ++;
			}
			if (compare(b, "[[2]]") == 1) {
				c1 ++;
			}
		}
		for (int i = 0; i < signal.size(); i += 3) {
			a = signal.get(i);
			b = signal.get(i + 1);
			if (compare(a, "[[6]]") == 1) {
				c2 ++;
			}
			if (compare(b, "[[6]]") == 1) {
				c2 ++;
			}
		}
		System.out.println("Key:  " + c1 *c2);
	}

	private static boolean isList(String a) {
		return a.charAt(0) == '[';
	}

	private static int compare(String a, String b) {
		if (a.length() == 0 && b.length() ==0) {
			return 0;
		}
		if (a.length() == 0) {
			return 1;
		}
		if (b.length() == 0) {
			return -1;
		}
		if (!isList(a) && !isList(b)) {
			if (Integer.valueOf(a) == Integer.valueOf(b)) {
				return 0;
			}
			if (Integer.valueOf(a) > Integer.valueOf(b)) {
				return -1;
			}
			return 1;
		}
		if (isList(a) && !isList(b)) {
			b = "[" + b + "]";
		}
		if (!isList(a) && isList(b)) {
			a = "[" + a + "]";
		}
		if (isList(a) && isList(b)) {
			List<String> aa = splitToList(a);
			List<String> bb = splitToList(b);
			int i = 0;
			int ans;
			while (i < aa.size() && i < bb.size()) {
				ans = compare(aa.get(i), bb.get(i));
				if (ans != 0) {
					return ans;
				}
				i++;
			}
			if (i == aa.size()) {
				if (aa.size() == bb.size()) {
					return 0;
				}
				return 1;
			}
			return -1;
		}
		return 0;
	}

	private static List<String> splitToList(String a) {
		List<String> r = new ArrayList<>();
		int k = 0, s = 1;
		for (int i = 1; i < a.length() - 1; i++) {
			if (a.charAt(i) == '[') {
				k++;
			}
			if (a.charAt(i) == ']') {
				k--;
			}
			if (a.charAt(i) == ',' && k == 0) {
				r.add(a.substring(s, i));
				s = i + 1;
			}
		}
		r.add(a.substring(s, a.length() - 1));
		return r;
	}
}
